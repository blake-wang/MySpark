package cn.wanglei.spark.day05.demo2

import cn.wanglei.spark.day05.LoggerLevels
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by wanglei on 2017/6/5.
  *
  * 计算每个批次之后再累加起来
  */
object StateFullWordCount {
  //Seq这个批次某个单词的次数
  //Option[Int]:单词以前的结果

  //  分好组的数据
  //    val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
  //      //下面这几种写法都可以实现计算结果，区分他们
  //
  //      //iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
  //      //    iter.flatMap { case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(m => (x, m)) }
  //      //    iter.map(t => (t._1, t._2.sum + t._3.getOrElse(0)))
  //      iter.map { case (word, current_count, history_count) => (word, current_count.sum + history_count.getOrElse(0)) }
  //    }


  //----下面这种写法是为了去除重复，同样的数据值计算一次
  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
    //下面这几种写法都可以实现计算结果，区分他们

    //iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
    //    iter.flatMap { case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(m => (x, m)) }
    //    iter.map(t => (t._1, t._2.sum + t._3.getOrElse(0)))
    iter.map { case (word, current_count, history_count) => (word, 1)

    }
  }


  def main(args: Array[String]): Unit = {

    LoggerLevels.setStreamingLogLevels()

    val conf = new SparkConf().setAppName("StateFullWordCount").setMaster("local[2]")

    val sc = new SparkContext(conf)

    //用updateStateByKey必须setCheckpointDir ,为了容错，这种累加计算，最怕数据丢失
    sc.setCheckpointDir("H:\\ck0605")

    val ssc = new StreamingContext(sc, Seconds(5))

    val ds = ssc.socketTextStream("192.168.33.21", 8888)

    //这个updateStateByKey是关键方法
    //updateStateByKey结果可以累加但是需要传入一个自定义的累加函数：updateFunc
    val result = ds.flatMap(_.split(" ")).map((_, 1))
      .updateStateByKey(updateFunc, new HashPartitioner(sc.defaultParallelism), true)

    result.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
