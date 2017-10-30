package cn.wanglei.spark.FlumePullAndPush

import java.net.InetSocketAddress
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by wanglei on 2017/6/6.
  * 从flume中拉取数据到spark
  */

object FlumePollWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("FlumePollWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    //从flume中拉取数据(flume的地址),可以写多个地址，从多处拉取数据
    val address = Seq(new InetSocketAddress("192.168.33.21", 8888))
    val flumeStream = FlumeUtils.createPollingStream(ssc, address, StorageLevel.MEMORY_AND_DISK)
    val words = flumeStream.flatMap(x => new String(x.event.getBody().array()).split(" ")).map((_, 1))
    val result = words.reduceByKey(_ + _)
    result.print()
    ssc.start()
    ssc.awaitTermination()
  }
}

