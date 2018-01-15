package demo.secondSortDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/1.
  * 二次排序
  *
  * 案例：
  * 1、按照文件中的第一列排序
  * 2、如果第一列相同，则按照第二列排序
  */
object demo2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\sort.txt")
    val pairs = rdd.map {
      line => (new SecondSort(line.split(" ")(0).toInt, line.split(" ")(1).toInt), line)
    }
    val sortedPairs = pairs.sortByKey()
    val sortLines = sortedPairs.map(sortedPair => sortedPair._2)
    sortLines.foreach(println(_))
  }

}
