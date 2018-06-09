package baseSpark.cache_RDD_Demo

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/4/14.
  */
object CheckPointRDD {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getLogger("就想看看日志长啥样")
    logger.setLevel(Level.WARN)

    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[2]")
    val sparkContext = new SparkContext(sparkConf)
    sparkContext.setCheckpointDir("F:\\IdeaProjects\\MySpark\\src\\testData\\checkponit")
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\hello.txt")
    rdd.checkpoint()


    println(sparkContext.getCheckpointDir)
    println(rdd.collect().toBuffer)
    //    println(rdd.collect().toBuffer)



  }

}
