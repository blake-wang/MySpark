package baseSpark.transformationAndaction.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * map
  *
  * 案例：将集合中每一个元素都乘以2
  */
object mapDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5)
    val arrRDD = sparkContext.parallelize(arr)
    //map也会生成新的RDD
    val result = arrRDD.map(_ * 2)
    result.foreach(println(_))
  }
}
