package baseSpark.UDF_Demo

import com.sun.prism.PixelFormat.DataType
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.{SparkConf, SparkContext}
import udf.GetJsonObjectUDF

/**
  * Created by bigdata on 18-1-20.
  * 创建自定义函数 getJsonValue
  * 取出数组中的值
  * {"endAge":["50"],"endDate":["2016-06-21"],"startAge":["10"],"startDate":["2016-06-21"]}
  */
object UDF_Demo2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val hiveContext = new HiveContext(sparkContext)

    val df = hiveContext.read.text("file:///home/bigdata/IdeaProjects/MySpark/src/testData/jsonUDF.txt")
    df.show()
    df.registerTempTable("ods_json")


    hiveContext.udf.register("getJsonValue", new GetJsonObjectUDF(), DataTypes.StringType)

    val resDF = hiveContext.sql("select getJsonValue(value,'startDatea') from ods_json")
    resDF.show()


  }


}
