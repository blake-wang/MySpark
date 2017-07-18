package MyTestCode

import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/7/18.
  */
object StructTypeDemo {
  def main(args: Array[String]): Unit = {
    //创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("SQL-2")
    //SQLContext要依赖SparkContext
    val sc = new SparkContext(conf)
    //创建SQLContext
    val sqlContext = new SQLContext(sc)
    //从指定的地址创建RDD
    val personRDD = sc.textFile(args(0)).map(_.split(" "))
    //通过StructType，直接指定每个字段的schema
    val schema = StructType(
      List(
        StructField("id", IntegerType, true),
        StructField("name", IntegerType, true),
        StructField("age", IntegerType, true)
      )
    )
    //将RDD映射到rowRDD
    val rowRDD = personRDD.map(p => Row(p(0).toInt, p(1).trim, p(2).toInt))

  }

}
