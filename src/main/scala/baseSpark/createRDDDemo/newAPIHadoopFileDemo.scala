package baseSpark.createRDDDemo

import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 17-12-22.
  * newAPIHadoopFile
  */
object newAPIHadoopFileDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd1 = sparkContext.newAPIHadoopFile("hdfs://master-yyft:9000/user/hive/warehouse/yyft.db/active/logs_active_20171216",
      classOf[CombineTextInputFormat],
      classOf[LongWritable],
      classOf[Text]).map(line => line._2.toString)
      .union(sparkContext.newAPIHadoopFile("hdfs://master-yyft:9000/user/hive/warehouse/yyft.db/active/logs_active_20171217",
        classOf[CombineTextInputFormat],
        classOf[LongWritable],
        classOf[Text]).map(line => line._2.toString))

    rdd1.foreachPartition(iter => {
      iter.foreach(line => {
        println(line)
      })
    })
    sparkContext.stop()

  }

}
