package cn.wanglei.spark.day05.demo1

import cn.wanglei.spark.day05.LoggerLevels
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/5.
  *
  * //计算单批次数据的wordcount
  */
object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    //设置日志打印
    LoggerLevels.setStreamingLogLevels()

    //创建StreamingContext
    //    17/06/07 08:25:41 WARN StreamingContext: spark.master should be set as local[n], n > 1 in local mode if you have receivers to get data, otherwise Spark jobs will not get resources to process the received data.
    val conf = new SparkConf().setAppName("StreamingWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //第二个参数是间隔时间，5秒为一个批次
    //    -------------------------------------------
    //    Time: 1496668030000 ms
    //    -------------------------------------------
    //    -------------------------------------------
    //    Time: 1496668035000 ms
    //    -------------------------------------------
    val ssc = new StreamingContext(sc, Seconds(5))
    //DStream是一个特殊的RDD
    //接收数据
    val ds = ssc.socketTextStream("192.168.33.21", 8888)
    //处理的是一个批次的数据，也就是5秒期间产生的数据
    val result = ds.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    //打印结果
    result.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
