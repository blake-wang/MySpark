package baseSpark.cache_RDD_Demo

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * RDD持久化
  * cache()方法，persist()方法
  *
  * 持久化的级别
  * StorageLevel枚举类
  * MEMORY_ONLY
  * MEMORY_AND_DISK
  * MEMORY_ONLY_SER
  *
  */
object cacheRDDDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val rdd = sparkContext.textFile("F:\\IdeaProjects\\MySpark\\src\\testData\\count.txt") //.cache()
    rdd.persist(StorageLevel.MEMORY_ONLY)
    //    rdd.persist(StorageLevel.MEMORY_AND_DISK)
    //    rdd.persist(StorageLevel.MEMORY_ONLY_SER)
    //    rdd.persist(StorageLevel.MEMORY_AND_DISK_SER)
    //    rdd.persist(StorageLevel.DISK_ONLY)


    var startTime = System.currentTimeMillis()
    //count是个action操作,第一次执行count的时候，会从读取文件开始生成rdd
    var linesNum = rdd.count()
    var endTime = System.currentTimeMillis()
    println(linesNum)
    println("use time 1: " + (endTime - startTime))

    //    rdd.persist()

    startTime = System.currentTimeMillis()
    //第二次执行count的时候，直接读取缓存的rdd，因此第二次count计算时间很快
    linesNum = rdd.count()
    endTime = System.currentTimeMillis()
    println(linesNum)
    println("use time 2: " + (endTime - startTime))
    //    rdd.unpersist()
  }

}
