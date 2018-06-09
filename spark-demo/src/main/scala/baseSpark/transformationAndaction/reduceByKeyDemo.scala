package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * reduceByKey
  *
  * 案例：计算成绩的总分
  */
object reduceByKeyDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(("wanglei", 80), ("wanglei", 60), ("aixu", 70), ("aixu", 100))
    val tupleRDD = sparkContext.parallelize(arr)
    //reduceByKey会生成一个新的RDD
    val result = tupleRDD.reduceByKey(_ + _)
    result.foreach(println(_))
  }

}
