package cn.wanglei.spark.day02

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/1.
  * 计算，按主域名分组，按访问量将子域名排序，取出前三名
  */
object UrlCount {
  def main(args: Array[String]): Unit = {
    val config = new SparkConf().setAppName("UrlCount").setMaster("local[2]")
    val sc = new SparkContext(config)

    //切割原始数据，并把(url,1)输出
    val rdd1 = sc.textFile("H:\\itcast.log").map(line => {
      val f = line.split("\t")
      (f(1), 1)
    })

    val rdd2 = rdd1.reduceByKey(_ + _)
    println("rdd2  :  " + rdd2.collect().toBuffer)

    val rdd3 = rdd2.map(t => {
      val url = t._1
      //http://php.itcast.cn/php/course.shtml--->php.itcast.cn
      val host = new URL(url).getHost
      (host, url, t._2)
    })
    println("rdd3  :  " + rdd3.collect())


    val rdd4 = rdd3.groupBy(_._1)
    println("rdd4  :  " + rdd4.collect().toBuffer)

    val rdd5 = rdd4.mapValues(it => {
      //加reverse是从大到小排序，不加是从小到大排序
      it.toList.sortBy(_._3).reverse.take(3)
    })
    println("rdd5  :  " + rdd5.collect().toBuffer)

    sc.stop()
  }
}
