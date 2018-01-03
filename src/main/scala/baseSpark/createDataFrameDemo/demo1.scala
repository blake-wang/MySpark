package baseSpark.createDataFrameDemo

import org.apache.spark.sql.{SQLContext, SaveMode}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/2.
  * 通过json文件创建dataFrame
  */
object demo1 {
  def main(args: Array[String]): Unit = {
    val hdfsParquetFileDir = "hdfs://master-yyft:9000/tmp/hive/test/"
    val localParquetFileDir = "/home/bigdata/IdeaProjects/MySpark/src/testData/ParquetDir/"

    val sparkConf = new SparkConf().setAppName(getClass.getName.replace("$", "")).setMaster("local[1]")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    //读取json文件的方式生成dataFrame
    val df = sqlContext.read.json("/home/bigdata/IdeaProjects/MySpark/src/testData/jsonData.txt")
    df.show()


    //dataFrame的write默认保存的是parquet格式
    df.write.mode(SaveMode.Overwrite).save(hdfsParquetFileDir)

    //读取parquet文件的方式生成dataFrame
    val df2 = sqlContext.read.parquet(hdfsParquetFileDir)
    df2.show()

    sqlContext.


  }

}
