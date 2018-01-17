package baseSpark.SparkSQLDemo

import java.util.Properties

import Utils.StringUtils
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, Row, SQLContext, SaveMode}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/2.
  *
  * DataFrame
  *
  * 其中的每一行都是 Row
  *
  *
  */
object createDataFrameDemo {
  def main(args: Array[String]): Unit = {
    val hdfsParquetFileDir = "hdfs://master-yyft:9000/tmp/hive/test/"
    val localParquetFileDir = "/home/bigdata/IdeaProjects/MySpark/src/testData/ParquetDir/"

    val sparkConf = new SparkConf().setAppName(getClass.getName.replace("$", "")).setMaster("local[1]")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    //读取json文件的方式生成dataFrame
    //数据源  1：本地文件 2：hdfs文件

    //创建dataFrame

    //1:通过读取json文件
//    val df: DataFrame = json(sqlContext)
//
//    //dataFrame的write默认保存的是parquet格式
//    df.write.mode(SaveMode.Overwrite).save(hdfsParquetFileDir)
//
//    //2：通过读取parquet文件
    parquet(hdfsParquetFileDir, sqlContext)
//
//    //3：通过hiveSQL语句查询
//    hiveSql(sc)
//
//    //4：通过rdd创建 ->RDD装的是row才行
//    rdd(sc, sqlContext)

    //5：通过MySql语句查询  注意： 该方法读取的是整张表，所以只能用于读取小表，表的数据数据过大会导致内存溢出
//    mySql(sc)





    sc.stop()
  }

  private def mySql(sc: SparkContext) = {
    //注意： 该方法读取的是整张表，所以只能用于读取小表，表的数据数据过大会导致内存溢出
    val url = "jdbc:mysql://192.168.20.60:3306/xiaopeng2_faxing?user=xiaopeng&password=xiaopeng99&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull"
    val tableName = "ranking"
    val jdbc_xiaopeng2fx_user = "xiaopeng"
    val jdbc_xiaopeng2fx_pwd = "xiaopeng99"
    val jdbc_driver = "com.mysql.jdbc.Driver"
    val properties = new Properties();
    properties.put("driver", jdbc_driver)
    properties.put("user", jdbc_xiaopeng2fx_user)
    properties.put("password", jdbc_xiaopeng2fx_pwd)
    val hiveContext = new HiveContext(sc)
    val jdbcDF = hiveContext.read.jdbc(url, tableName, properties)
    jdbcDF.registerTempTable(tableName)
    jdbcDF.show()
  }

  private def rdd(sc: SparkContext, sqlContext: SQLContext) = {
    val rdd = sc.textFile("hdfs://master-yyft:9000/user/hive/warehouse/yyft.db/regi/logs_regi_20171216")
    val regiRdd = rdd.filter(line => {
      val arr: Array[String] = line.split("\\|", -1)
      arr(0).contains("bi_regi") && arr.length >= 15
    }).map(line => {
      val arr: Array[String] = line.split("\\|", -1)
      Row(arr(3), arr(4).toInt, StringUtils.getArrayChannel(arr(13))(0), StringUtils.getArrayChannel(arr(13))(1), StringUtils.getArrayChannel(arr(13))(2), arr(5), arr(14))
    })

    val structType = new StructType()
      .add("game_account", StringType)
      .add("game_id", IntegerType)
      .add("parent_channel", StringType)
      .add("child_channel", StringType)
      .add("ad_label", StringType)
      .add("reg_time", StringType)
      .add("imei", StringType);
    val df4 = sqlContext.createDataFrame(regiRdd, structType)
    df4.show()
  }

  private def json(sqlContext: SQLContext) = {
    //    1：本地文件
    val df = sqlContext.read.json("file:///home/bigdata/IdeaProjects/MySpark/src/testData/jsonData.txt")
    //    val df = sqlContext.read.json("/home/bigdata/IdeaProjects/MySpark/src/testData/jsonData.txt")
    //    val df = sqlContext.read.json("hdfs://master-yyft:9000/home/bigdata/IdeaProjects/MySpark/src/testData/jsonData.txt")
    df.show()
    df
  }

  private def parquet(hdfsParquetFileDir: String, sqlContext: SQLContext) = {
    //读取parquet文件的方式生成dataFrame
//    val df2 = sqlContext.read.parquet(hdfsParquetFileDir)
//    df2.show()

    val df3 = sqlContext.read.parquet("file:///home/bigdata/data/par*")
    df3.show()


  }

  private def hiveSql(sc: SparkContext) = {
    //通过sql的方式创建dataFrame
    val hiveContext = new HiveContext(sc)
    val df3 = hiveContext.sql("select * from yyft.ods_active limit 10")
    df3.show()
  }
}
