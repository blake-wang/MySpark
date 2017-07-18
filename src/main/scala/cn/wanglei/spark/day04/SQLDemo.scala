package cn.wanglei.spark.day04

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/4.
  */
object SQLDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SQLDemo").setMaster("spark://192.168.33.21:7077")
      //                                                        .setMaster("local[2]")
      .setJars(Array("F:\\IdeaProjects\\HelloSpark\\out\\artifacts\\SQLDemo\\SQLDemo.jar"))
      //设置driver端的ip,这里是你本机的ip
      .setIfMissing("spark.driver.host", "192.168.16.111")


    val sc = new SparkContext(conf)

    //创建SQLContext
    val sqlContext = new SQLContext(sc)

    //从指定的地址创建RDD
    val lineRDD = sc.textFile("hdfs://192.168.33.21:9000/people.txt").map(_.split(","))
    println(lineRDD.collect())

    //创建 case class
    //将RDD和case class关联
    val personRDD = lineRDD.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    //导入隐式转换，如果不导入，无法将RDD转换成DataFrame
    import sqlContext.implicits._
    //将RDD转换成DataFrame
    val personDF = personRDD.toDF
    //注册表
    personDF.registerTempTable("person")
    //传入SQL
    val df = sqlContext.sql("select * from person where age >= 28 order by id desc limit 2")

    //show查询结果
    df.show()
    sc.stop()
  }
}

case class Person(id: Int, name: String, age: Int)
