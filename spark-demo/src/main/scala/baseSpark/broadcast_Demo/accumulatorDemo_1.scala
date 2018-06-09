package baseSpark.broadcast_Demo

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bigdata on 18-1-22.
  * 累加器
  *
  *
  */
object accumulatorDemo_1 {
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

    //用累加器将ab发布到每个节点,只有这样，才能把每一行的数据添加到这个变量中
    val ab = new ArrayBuffer[String]()
    val c = 0
    val abVar = sparkContext.broadcast(c)


    df2.foreachPartition(iter => {
      var xx = abVar.value
      iter.foreach(line => {
        xx.+=(1)
      })
    })
    println(c)

  }

}
