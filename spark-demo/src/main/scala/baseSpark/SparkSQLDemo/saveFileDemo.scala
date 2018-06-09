package baseSpark.SparkSQLDemo

import java.io.{BufferedWriter, FileWriter}

import org.apache.spark.sql.DataFrame
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by bigdata on 18-1-20.
  * 将dataFrame里面的数据写到本地文件
  *
  * 两种方式：
  * 1: df2.write.save()
  * 2: BufferedWriter
  *
  */
object saveFileDemo {

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

    //在每个分区创建对象的写法写入到本地文件
    //    demo1(df2)

    //用共享变量的方式，将对象发送到每个partition -->想想倒是可以，其实这样是不行的
    val br = new BufferedWriter(new FileWriter("src/testData/udfResultVar.txt"))
    val brVar = sparkContext.broadcast(br)

    df2.foreachPartition(iter => {
      val br = brVar.value
      iter.foreach(line => {
        br.write(line.toString())
        br.newLine()
      })
      br.flush()
    })
    br.close()


  }


  private def demo1(df2: DataFrame) = {
    //如果要将数据以字符流的方式写入到本地文件,有几点要注意一下
    //1：只能在local模式下才能写
    //2：在每一个partition里面创建 BufferedWriter，或者是在每一行写入时都创建
    //3：不管有几个partition，都会将df里面的数据全部写入到本地文件，不会产生覆盖
    df2.coalesce(3)
    df2.foreachPartition(iter => {
      //在每一个partition里面创建 BufferedWriter
      val br = new BufferedWriter(new FileWriter("src/testData/udfResult.txt"))
      iter.foreach(line => {
        br.write(line.toString())
        br.newLine()
      })
      br.flush()
      br.close()
    })
  }
}
