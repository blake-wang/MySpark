package baseSpark

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by JSJSB-0071 on 2017/7/23.
 */
object mapPartitionsWithIndexDemo {

  //这个函数是查看每个分区里面有什么
  val func = (index: Int, iter: Iterator[(Int)]) => {
    iter.toList.map(x => "[partID:" + index + ",val:" + x + "]").iterator
  }

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("wc").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 2)
    //ParallelCollectionRDD[0] at parallelize
    println(rdd1)
    //mapPartitionsWithIndex这个方法查看的是每一个分区里面的元素
    val rdd2 = rdd1.mapPartitionsWithIndex(func)
    println(rdd2) //MapPartitionsRDD[1] at mapPartitionsWithIndex
    println(rdd2.collect().toBuffer)
  }
}
