package baseSpark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/7/24.
  */
object foreachDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wc").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 2)
    //用foreach不会产生新的rdd，它没有返回值
    rdd1.foreach(println(_))
    val rdd2 = rdd1.foreach(x => {
      println(x * 2)
    })
  }
}

