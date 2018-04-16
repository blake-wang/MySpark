package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * reduce
  *
  * 聚合：将多个元素聚合成一个元素
  */
object reduceDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val rdd = sparkContext.parallelize(arr)
    val result = rdd.reduce(_ + _)
    println(result)

  }

}
