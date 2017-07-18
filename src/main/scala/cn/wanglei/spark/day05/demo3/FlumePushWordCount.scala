package cn.wanglei.spark.day05.demo3

import cn.wanglei.spark.day05.LoggerLevels
import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by wanglei on 2017/6/6.
  * 从flume向spark推送push数据 -----  这种方式很少用
  */
object FlumePushWordCount {
  def main(args: Array[String]): Unit = {
    LoggerLevels.setStreamingLogLevels()
    val conf = new SparkConf().setAppName("FlumePushWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    //推送方式  flume向spark发送数据
    val flumeStream = FlumeUtils.createStream(ssc, "192.168.33.21", 8888)
    //flume中的数据通过event.getBody()才能拿到真正的内容
    val words = flumeStream.flatMap(x => new String(x.event.getBody().array()).split(" ").map((_, 1)))
    val results = words.reduceByKey(_ + _)
    results.print()
    ssc.start()
    ssc.awaitTermination()

  }

}
