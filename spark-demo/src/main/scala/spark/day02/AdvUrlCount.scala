package cn.wanglei.spark.day02

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/1.
  * 利用RDD的排序
  * 计算，按主域名分组，按访问量将子域名排序，取出前三名
  */
object AdvUrlCount {
  def main(args: Array[String]): Unit = {
    val config = new SparkConf().setAppName("AdvUrlCount").setMaster("local[2]")
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
      (host, url, t._2)
    })
    //在实际生产中，不能把匹配规则写死，如果写死，项目需求变更，更改起来麻烦
    //    val rddjava = rdd3.filter(_._1 == "java.itcast.cn")
    //    println("rddjava  :  " + rddjava.collect().toBuffer)
    //
    //
    //    val sortedjava = rddjava.sortBy(_._3, false).top(3)
    //    println("sortedjava  :  " + sortedjava.toBuffer)


    //通过rdd计算
    for (ins <- arr) {
      val rdd = rdd3.filter(_._1 == ins)
      //按照访问次数，倒序排序，取前三名
      val result = rdd.sortBy(_._3, false).take(3)
      println("result  :  " + result.toBuffer)
    }


    sc.stop()
  }

}
