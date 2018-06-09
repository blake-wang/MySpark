package Test

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/29.
  */

object SqlDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MySqlDemo")
    //.setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val lineRDD = sc.textFile("hdfs://192.168.33.21:9000/people.txt").map(_.split(","))
    val personRDD = lineRDD.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    import sqlContext.implicits._
    val personDF = personRDD.toDF
    personDF.registerTempTable("person")
    val df = sqlContext.sql("select * from person where age >= 28 order by age desc limit 2")
    df.show()
    //我只想说，我就是添加了一个注释而已
    sc.stop()
  }
}

case class Person(id: Int, name: String, age: Int)



