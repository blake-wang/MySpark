package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * count
  *
  * 统计一个RDD中有几个元素
  */
object countDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val rdd = sparkContext.parallelize(arr)
    //计算rdd中元素的数量
    val num = rdd.count()
    println(num)
  }
}
