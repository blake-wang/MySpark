package baseSpark.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * cogroup
  *
  * cogroup的使用方法要注意
  */
object cogroup {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr1 = Array((1, "wanglei"), (2, "aixu"), (3, "志超"))
    val arr2 = Array((9, 28), (2, 26), (3, 29))
    val rdd1 = sparkContext.parallelize(arr1)
    val rdd2 = sparkContext.parallelize(arr2)
    val rdd3 = rdd1.cogroup(rdd2)
    rdd3.foreach(println(_))
  }
}
