package cn.wanglei.spark.day02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/1.
  * 初级版
  * 计算手机用户在基站的停留时间
  */
object UserLocation {
  def main(args: Array[String]): Unit = {
    //写代码，现在本地模式运行，如果没有问题，再提交到集群
    val config = new SparkConf().setAppName("MobileUserLocation").setMaster("local[2]")
    val sc = new SparkContext(config)
    //    sc.textFile("H:\\bs_log").map(_.split(",")).map(x => (x(0), x(1), x(2), x(3)))
    var mbt = sc.textFile("H:\\bs_log").map(line => {
      val fields = line.split(",")
      val eventType = fields(3)
      val time = fields(1)
      val timeLong = if (eventType == "1") -time.toLong else time.toLong
      (fields(0) + "_" + fields(2), timeLong)
    })
    println("mbt  :  " + mbt.collect().toBuffer)

    val result = mbt.groupBy(_._1)
    println("result  :  " + result.collect().toBuffer)

    val result2 = mbt.groupBy(_._1).mapValues(_.foldLeft(0L)(_ + _._2))
    println("result2  :  " + result2.collect().toBuffer)

    val result3 = result2.map(t => {
      val mobile_bs = t._1
      val mobile = mobile_bs.split("_")(0)
      val lac = mobile_bs.split("_")(1)
      val time = t._2
      (mobile, lac, time)
    })
    println("result3  :  " + result3.collect().toBuffer)

    val result4 = result3.groupBy(_._1)
    println("result4  :  " + result4.collect().toBuffer)

    val result5 = result4.mapValues(it => {
      it.toList.sortBy(_._3).reverse.take(2)
    })
    println("result5  :  " + result5.collect().toBuffer)

    sc.stop()
  }
}
