package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  *
  * take
  *
  * 获取集合中前几个元素
  *
  * take操作与collect类似，也是从远程集群上，获取rdd的数据
  * 但是collect是获取rdd的所有数据，take只是获取前n个数据
  *
  */
object takeDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(19, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val rdd = sparkContext.parallelize(arr)
    val result = rdd.take(3)
    println(result.toBuffer)
    result.foreach(println(_))
  }
}
