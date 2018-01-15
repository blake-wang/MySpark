package demo.sortDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/1.
  * 案例需求：
  * 1、对文本文件内的每个单词都统计出其出现的次数
  * 2、按照每个单词出现次数的数量，降序排序
  */
object demo1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\hello.txt")

    //统计单词出现的次数
    val words = rdd.flatMap(line => line.split(" "))
    val tupleRDD = words.map(word => (word, 1))
    val result = tupleRDD.reduceByKey(_ + _)
    result.foreach(println(_))
    println("=======================================")

    //按键排序
    val revTuple = result.map(tuple => (tuple._2, tuple._1))
    val resultSorted = revTuple.sortByKey()
    resultSorted.foreach(println(_))
  }
}
