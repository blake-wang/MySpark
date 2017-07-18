package cn.wanglei.spark.day01

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/5/31.
  */
object WordCount {


  def main(args: Array[String]): Unit = {
    //运行在集群模式
    //非常重要，是通向Spark集群的入口

    //1、打jar包在集群运行，用 spark-submit提交任务的时候，用这个
    //val conf = new SparkConf().setAppName("WC")

    //2、本地运行方式，没在集群上运行，开启一个单进程，模拟了spark的运行过程
    //val conf = new SparkConf().setAppName("WC").setMaster("local[2]")


    //集群运行模式，远程调控
    val conf = new SparkConf().setAppName("WC")
      .setJars(Array("F:\\IdeaProjects\\HelloSpark\\target\\hellospark-1.0.jar"))
      .setMaster("spark://192.168.33.21:7077")

    val sc = new SparkContext(conf)

    //textFile会产生两个RDD：HadoopRDD -> MapPartitionsRDD
    sc.textFile("hdfs://192.168.33.21:9000/wdin")
      //产生一个RDD：MapPartitinsRDD
      .flatMap(_.split(" "))
      //产生一个RDD：MapPartitinsRDD
      .map((_, 1))
      //产生一个RDD： ShuffleRDD
      .reduceByKey(_ + _)
      //
      .sortBy(_._2, false)
      //mapPartitions
      .saveAsTextFile("hdfs://192.168.33.21:9000/wdout")
    sc.stop()
  }

}
