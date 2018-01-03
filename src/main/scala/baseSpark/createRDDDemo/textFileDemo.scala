package baseSpark.createRDDDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 17-12-22.
  * testFile
  */
object textFileDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd1 = sparkContext.textFile("hdfs://master-yyft:9000/user/hive/warehouse/yyft.db/active/logs_active_20171216")
      .union(sparkContext.textFile("hdfs://master-yyft:9000/user/hive/warehouse/yyft.db/active/logs_active_20171217"))
    rdd1.foreachPartition(iter => {
      iter.foreach(line => {
        println(line)
      })
    })
  }

}
