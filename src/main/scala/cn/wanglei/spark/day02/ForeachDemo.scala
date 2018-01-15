package cn.wanglei.spark.day02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/1.
  */
object ForeachDemo {
  def main(args: Array[String]): Unit = {
    //运行在本地模式
    //"local"默认为1个进程 ，"local[2]"设置为2个进程
    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
    //    rdd1.foreach(println(_))
    sc.stop()
  }
}
