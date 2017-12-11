package baseSpark.broadcastDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 17-12-1.
  * 广播变量
  */
object testBroadCast {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3)
    val sparkConf = new SparkConf().setAppName("haha").setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)

    val broadcastVar = sparkContext.broadcast(arr)
    for (i <- broadcastVar.value) {
      println(i)
    }


  }
}
