package baseSpark.WordCountDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/30.
  * WordCount 测试程序
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val lines = sparkContext.textFile("F:\\testData.txt")
    val words = lines.flatMap(lines => {
      lines.split(" ")
    })
    val tuple2 = words.map(words => {
      (words, 1)
    })
    val result = tuple2.reduceByKey(_ + _)
    result.foreachPartition(iter => {
      iter.foreach(println(_))
    })
    //    result.repartition(1)
    result.saveAsTextFile("F:\\Data\\OutPut6")
    sparkContext.stop()

  }
}
