package baseSpark.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * reduceByKey
  *
  * 案例：统计每个班级的总分
  */
object reduceByKeyDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(("wanglei", 80), ("wanglei", 60), ("aixu", 70), ("aixu", 100))
    val tupleRDD = sparkContext.parallelize(arr)
    //groupByKey直接使用,不用传入参数
    val result = tupleRDD.groupByKey
    result.foreach(index => {
      println(index._1)
      index._2.foreach(println(_))
    })

  }
}
