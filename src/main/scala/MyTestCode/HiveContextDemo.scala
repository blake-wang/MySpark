package MyTestCode

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/7/15.
  */
object HiveContextDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("hive").setMaster("spark://192.168.33.21:7077")
      .setJars(Array("F:\\IdeaProjects\\HelloSpark\\out\\artifacts\\SQLDemo\\SQLDemo.jar"))
      //设置driver端的ip,这里是你本机的ip
      .setIfMissing("spark.driver.host", "192.168.16.111")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)

    sqlContext.sql("use est")
    val df = sqlContext.sql("select * from student").registerTempTable("result")
    val result = sqlContext.sql("select * from result")

    result.foreachPartition(rows=>{
      for(row <- rows){
        println(row.get(0))
      }
    })
    sc.stop()

  }

}
