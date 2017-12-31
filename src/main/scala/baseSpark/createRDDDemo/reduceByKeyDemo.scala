package baseSpark.createRDDDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/30.
  * reduceByKey
  *
  * 案例：统计每行单词出现的次数
  */
object reduceByKeyDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", ""))
      .setMaster("local[2]")
    val sparkContext = new SparkContext(sparkConf)
    val lines = sparkContext.textFile("F:\\Data\\hello.txt")
    val pairRDD = lines.map(line => (line, 1))
    val linePair = pairRDD.reduceByKey(_ + _)
    linePair.foreach(println(_))
  }
}
