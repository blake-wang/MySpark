package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * groupByKey
  *
  * 案例：统计每个班级的总分
  *
  */
object groupByKeyDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(("wanglei", 80), ("wanglei", 60), ("aixu", 70), ("aixu", 100))
    val tupleRDD = sparkContext.parallelize(arr)
    //groupByKey直接使用,不用传入参数
    val result = tupleRDD.groupByKey
    result.foreach(tuple2 => {
      println(tuple2._1)
      //      tuple2._2.foreach(println(_))
      tuple2._2.

    })
  }

}
