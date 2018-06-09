package cn.wanglei.spark.day02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/1.
  * 高级版
  * 计算手机用户在基站的停留时间
  *
  */
object AdvanceUserLocation {
  def main(args: Array[String]): Unit = {
    //写代码，现在本地模式运行，如果没有问题，再提交到集群
    val config = new SparkConf().setAppName("MobileUserLocation").setMaster("local[2]")
    val sc = new SparkContext(config)
    //读取文件，按元组输出
    var rdd0 = sc.textFile("H:\\bs_log").map(line => {
      val fields = line.split(",")
      val eventType = fields(3)
      val time = fields(1)
      val timeLong = if (eventType == "1") -time.toLong else time.toLong
      ((fields(0), fields(2)), timeLong)
    })
    println("mbt  :  " + rdd0.collect().toBuffer)

    //时间求和
    val rdd1 = rdd0.reduceByKey(_ + _).map(t => {
      val mobile = t._1._1
      val lac = t._1._2
      val time = t._2
      (lac, (mobile, time))
    })
    println("rdd1  :  " + rdd1.collect().toBuffer)

    //导入另一个数据文件
    val rdd2 = sc.textFile("H:\\lac_info.txt").map(line => {
      val f = line.split(",")
      //基站ID，(经度，纬度)
      (f(0), (f(1), f(2)))
    })
    println("rdd2  :  " + rdd2.collect().toBuffer)

    //两个数据文件join
    val rdd3 = rdd1.join(rdd2)
    println("rdd3  :  " + rdd3.collect().toBuffer)


    //按用户分成元组
    val rdd4 = rdd3.map(t => {
      val mobile = t._2._1._1
      val lac = t._1
      val time = t._2._1._2
      val x = t._2._2._1
      val y = t._2._2._2
      (mobile, lac, time, x, y)
    })
    println("rdd4  :  " + rdd4.collect().toBuffer)


    //rdd5 是按mobile分好组的
    val rdd5 = rdd4.groupBy(_._1)
    println("rdd5  :  " + rdd5.collect().toBuffer)

    //排序后取time前2
    val rdd6 = rdd5.mapValues(it => {
      it.toList.sortBy(_._3).reverse.take(2)
    })
    println("rdd6  :  " + rdd6.collect().toBuffer)

    //保存计算结果
    rdd6.saveAsTextFile("H:\\SparkOut")

    sc.stop()
  }
}
