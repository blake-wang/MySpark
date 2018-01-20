package baseSpark.create_RDD_Demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/30.
  * 通过集合并行化创建RDD
  *
  *
  */
object listDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setAppName(this.getClass.getName.replace("$", ""))
      .setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val parallelizeRDD = sparkContext.parallelize(arr)
    val result = parallelizeRDD.reduce(_ + _)
    parallelizeRDD.foreach(println(_))
    println(result)

  }
}
