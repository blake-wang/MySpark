package demo.topNDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/1.
  * top3
  *
  * 案例需求：对文本文件内的数字，取最大的前3个
  *
  */
object topDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\top.txt")

    //将要排序的字符串转换成int类型，并和字符串本身组成tuple2
    val tuple2 = rdd.map(index => (index.toInt, index))

    //传入false，降序排序
    val sortedRDD = tuple2.sortByKey(false)
    val result = sortedRDD.map(tuple => tuple._2)
    //取出排序后的前三个元素
    val top3 = result.take(3)

    top3.foreach(println(_))
  }
}
