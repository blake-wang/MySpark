package cn.wanglei.spark.day03

import java.net.URL
import org.apache.spark.{Partitioner, SparkConf, SparkContext}
import scala.collection.mutable


/**
  * Created by wanglei on 2017/6/2.
  *
  */


object UrlCountPartition {
  def main(args: Array[String]): Unit = {
    val config = new SparkConf().setAppName("UrlCountPartition").setMaster("local[2]")
    val sc = new SparkContext(config)

    //从数据库中加载规则
    val arr = Array("java.itcast.cn", "php.itcast.cn", "net.itcast.cn")

    val rdd1 = sc.textFile("H:\\itcast.log").map(line => {
      val f = line.split("\t")
      (f(1), 1)
    })

    //返回的还是元组,聚合
    val rdd2 = rdd1.reduceByKey(_ + _)

    val rdd3 = rdd2.map(t => {
      val url = t._1
      val host = new URL(url).getHost
      (host, (url, t._2))
    }).cache()
    //cache会将数据缓存到内存当中，cache是一个Transformation，lazy
    //    rdd3.repartition(3).saveAsTextFile("H:\\out1")
    val ints = rdd3.map(_._1).distinct().collect()

    //自己定义的分区器
    val hostPartitioner = new HostPartitioner(ints)

    //按照自己定义的分区器进行分区
    //    rdd3.partitionBy(hostPartitioner).saveAsTextFile("H:\\out2")

    //对分区内的数据进行排序
    val rdd4 = rdd3.partitionBy(hostPartitioner).mapPartitions(it => {
      //按照访问次数排序，并取前2名
      it.toList.sortBy(_._2._2).reverse.take(2).iterator
    })

    //用HashPartitioner会产生Hash碰撞，有可能数据都跑到同一个分区中
    //    val rdd4 = rdd3.partitionBy(new HashPartitioner(3))

    rdd4.saveAsTextFile("H:\\out4")
    //    println("rdd4  :  " + rdd4.collect().toBuffer)
    sc.stop()

  }
}



//分区器，决定了数据到哪个分区里面   k-v类型数据才能分区
class HostPartitioner(ins: Array[String]) extends Partitioner {
  val parMap = new mutable.HashMap[String, Int]()
  var count = 0
  for (i <- ins) {
    parMap += (i -> count)
    count += 1
  }

  override def numPartitions: Int = ins.length

  override def getPartition(key: Any): Int = {
    parMap.getOrElse(key.toString, 0)
  }
}


