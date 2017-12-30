package baseSpark.createRDDDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/30.
  * 通过本地文件创建RDD
  *
  * 统计文本文件内的字数
  */
object localFileDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setAppName(this.getClass.getName.replace("$", ""))
      .setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val lines = sparkContext.textFile("F:\\testData.txt")
    val lineLength = lines.map(line => line.length)
    val result = lineLength.reduce(_ + _)
    println(result)


  }

}
