package baseSpark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by JSJSB-0071 on 2017/7/23.
  */
object foreachPartitionDemo {

  def main(args: Array[String]): Unit = {
    //把每一个分区拿出来操作，并且不会产生一个新的rdd，它没有返回值
    val conf = new SparkConf().setAppName("wc").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
    //foreachPartition,拿到的是每一个分区的iterator，iterator里面是分区里面的数据
    rdd1.foreachPartition(it => {
      it.foreach(println(_)
      )
    })
  }

}
