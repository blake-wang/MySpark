package baseSpark.broadcastDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/1.
  * Accumulator
  * 累加变量
  */
object accumulatorDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val a = 0
    val accumulatorVar = sparkContext.accumulator(a)

    val rdd = sparkContext.parallelize(arr)
    rdd.foreach(num => accumulatorVar += num)

    println(accumulatorVar)
  }
}
