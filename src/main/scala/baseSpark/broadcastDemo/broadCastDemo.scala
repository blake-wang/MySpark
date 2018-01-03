package baseSpark.broadcastDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * broadCast
  * 广播变量
  *
  */
object broadCastDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val a = 3
    val broadcastVar = sparkContext.broadcast(a)

    val rdd = sparkContext.parallelize(arr,3)
    val result = rdd.map(index => index * broadcastVar.value)
    result.foreach(println(_))

  }
}
