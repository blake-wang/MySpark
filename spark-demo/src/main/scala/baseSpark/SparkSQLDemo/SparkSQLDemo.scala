package baseSpark.SparkSQLDemo

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 18-1-4.
  * SparkSQL
  */
object SparkSQLDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)

    //    readJson(sqlContext)

  }

  private def readJson(sqlContext: SQLContext) = {
    //通过读取json文件创建dataDrame
    val df = sqlContext.read.json("file:///home/bigdata/IdeaProjects/MySpark/src/testData/nextjson.json")
    df.show
    //将dataFrame注册成临时表ods_json
    df.registerTempTable("ods_json")
    val addDF = sqlContext.sql("select addresses from ods_json")
    addDF.show()
  }
}
