package baseSpark.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * filter
  *
  * 案例：过滤出集合中的偶数
  */
object filterDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arrRDD = sparkContext.parallelize(arr)
    //使用filter会生成一个新的RDD
    val result = arrRDD.filter(index => (index % 2 == 0))
    result.foreach(println(_))
  }
}
