package cn.wanglei.spark.day05.kafkaWordCount

import cn.wanglei.spark.day05.LoggerLevels
import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by wanglei on 2017/6/6.
  */
object KafkaWordCount {
  //Seq这个批次某个单词的次数
  //Option[Int]:以前的结果

  //分好组的数据
  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
    //下面这几种写法都可以实现计算结果，区分他们

    //iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
    //    iter.flatMap { case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(m => (x, m)) }
    //    iter.map(t => (t._1, t._2.sum + t._3.getOrElse(0)))
    iter.map { case (word, current_count, history_count) => (word, current_count.sum + history_count.getOrElse(0)) }
  }

  def main(args: Array[String]): Unit = {
    LoggerLevels.setStreamingLogLevels()
    val Array(zkQuorum, group, topics, numThread) = args
    //    val zkQuorum = Array("192.168.33.21:2181", "192.168.33.22:2181", "192.168.33.23:2181")
    //    val group = "g1"
    //    val topicMap = Map("test" -> 2)

    val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    //这里的checkpoint和之前的setCheckPointDir是同一个方法，就是名字叫的不同
    ssc.checkpoint("c://ck1")
    val topicMap = topics.split(",").map((_, numThread.toInt)).toMap
    val data = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap)
    //    data.print()
    val words = data.map(_._2).flatMap(_.split(" "))
    val wordCounts = words.map((_, 1))
      .updateStateByKey(updateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true)
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()

  }
}
