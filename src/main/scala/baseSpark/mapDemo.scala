package baseSpark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/7/23.
  */
object mapDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wc").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List("dog", "pig", "haha", "heihei"), 2)

    //map会生成一个新的rdd
    val rdd2 = rdd1.map(x => {
      (x.length, x)
    })
    println(rdd2.collect().toBuffer)
  }
}
