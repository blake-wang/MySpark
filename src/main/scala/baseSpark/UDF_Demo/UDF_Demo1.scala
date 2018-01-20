package baseSpark.UDF_Demo

import java.io.{BufferedWriter, FileWriter}

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 18-1-20.
  * UDF函数
  *
  * 这是一个简单的例子，对一个字段的数值进行转换
  *
  * 需要注意的一点是，用hiveContext.read.json读取本地的json文件，
  * 因为resources目录下放了hdfs的配置文件，则项目的默认人间系统变成了hdfs的文件系统
  * 要读取本地文件，需要在路径前面使用 file:///
  *
  */
object UDF_Demo1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val hiveContext = new HiveContext(sparkContext)

    //从本地文件创建DF,因为在resources目录下放了hdfs的配置文件，默认目录变成了hdfs的目录
    val df1 = hiveContext.read.json("file:///home/bigdata/IdeaProjects/MySpark/src/testData/temperatures.txt")
    df1.show()

    //将df1注册成临时表
    df1.registerTempTable("citytemps")


    //注册生成UDF
    hiveContext.udf.register("CTOF", (degreesCelcius: Double) => ((degreesCelcius * 9.0 / 5.0) + 32.0))

    //在sql中使用使用udf函数
    val df2 = hiveContext.sql("select city,CTOF(avgLow) as avgLowF,CTOF(avgHigh) as avgHighF from citytemps")

    df2.show()


    //这种方式生成的是一个文件夹，里面存的是parquet文件
    //df2.write.save("file:///home/bigdata/IdeaProjects/MySpark/src/testData/DataFrameData/demo1")



    //如果要将数据以字符流的方式写入到本地文件,有几点要注意一下
    //1：只能在local模式下才能写
    //2：在每一个partition里面创建 BufferedWriter，或者是在每一行写入时都创建
    df2.foreachPartition(iter => {
      //在每一个partition里面创建 BufferedWriter
      val br = new BufferedWriter(new FileWriter("src/testData/udfResult.txt",true))
      iter.foreach(line => {
        br.write(line.toString())
        br.newLine()
      })
      br.close()
    })


  }

}
