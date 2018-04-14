package baseSpark.cache_RDD_Demo

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/4/14.
  * cache()
  *
  * 缓存RDD
  */
object Cache_RDD_DEMO {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getLogger("就想看看日志长啥样")
    logger.setLevel(Level.WARN)


    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[2]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\hello.txt")

    val rdd2 = rdd.cache()
    logger.info("到底行不行")
    println(rdd.count())
    println(rdd.take(3).toBuffer)

    println(rdd2.collect().toBuffer)
//    println(rdd.collect().toBuffer)



  }

}
