package baseSpark.partitionDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/22.
  * spark查看分区元素数工具
  *
  * spark中也有可能出现数据倾斜问题（如join等，当key有大部分相同时（如像hive数据倾斜那样join的字段很多为null））
  * 所以需要查看各分区的元素数据来判断数据各分区分布情况。
  * 以下是查看分区元素数的党法
  */
object demo1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("wanglei").setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.parallelize(Array(("A", 1), ("A", 1), ("A", 1), ("A", 1), ("A", 1)), 3)


    RDDUtils.getPartitionCounts(sparkContext, rdd).foreach(println)


  }


}
