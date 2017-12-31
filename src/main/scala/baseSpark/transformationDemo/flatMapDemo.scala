package baseSpark.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * flatMap
  * 案例：将文本每一行拆分为多个单词
  */
object flatMapDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array("hello you", "hello me", "hello wanglei")
    val strRDD = sparkContext.parallelize(arr)
    //flatMap也会生成一个新的RDD
    val result = strRDD.flatMap(line => line.split(" "))
    result.foreach(println(_))
  }
}
