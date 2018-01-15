package demo.topNDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/1.
  *
  * 分组取top3
  *
  * 案例需求：对每个班级内的学生成绩，取出前3名
  */
object topDemo2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\classTop.txt")
    val tupleRDD = rdd.map(line => (line.split(" ")(0), line.split(" ")(1)))
    val groupRDD = tupleRDD.groupByKey

    groupRDD.foreach(line => {
      println(line._1)
      val rdd2 = line._2.map(index => (index.toInt, index))
      println()


    })

  }
}
