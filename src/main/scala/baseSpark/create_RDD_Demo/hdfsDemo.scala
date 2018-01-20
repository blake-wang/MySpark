package baseSpark.create_RDD_Demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/30.
  * hdfs文件
  *
  */
object hdfsDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setAppName(this.getClass.getName.replace("$", ""))
      .setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val lines = sparkContext.textFile("hdfs://master:9000/home/testData.txt")
    val lineLength = lines.map(line => line.length)
    val result = lineLength.reduce(_ + _)
    println(result)
  }
}
