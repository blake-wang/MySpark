package cn.wanglei.spark.WindowOpts

import cn.wanglei.spark.LoggerLevels
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Milliseconds, Seconds, StreamingContext}

/**
  * Created by wanglei on 2017/6/7.
  * 窗口函数  计算一定时间区间的数据，但是不进行累加，只计算这个时间区间里的和
  */
object WindowsOpts {
      def main(args: Array[String]): Unit = {
        LoggerLevels.setStreamingLogLevels()
        val conf = new SparkConf().setAppName("WindowsOpts").setMaster("local[2]")
        val ssc = new StreamingContext(conf, Milliseconds(5000))
        val lines = ssc.socketTextStream("192.168.33.21", 9999)
        val pairs = lines.flatMap(_.split(" ")).map((_, 1))
        //第二个参数是 窗口时间 ，第三个参数是 滑动时间 ，这两个参数要是上面5000毫秒的倍数
        val windowedWordCount = pairs.reduceByKeyAndWindow((a: Int, b: Int) => (a + b), Seconds(15), Seconds(10))
        //    val a = windowedWordCount.map(_._2).reduce(_ + _)
        //    a.foreachRDD(rdd => {
        //      println(rdd.take(0))
        //    })
        //    a.print()
        windowedWordCount.print()
        ssc.start()
    ssc.awaitTermination()
  }

}
