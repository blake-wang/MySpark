package baseSpark.transformationDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * join
  * 案例：关联不同的RDD
  */
object joinDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr1 = Array((1, "wanglei"), (2, "aixu"), (3, "志超"))
    val arr2 = Array((9, 28), (2, 26), (3, 29))
    val rdd1 = sparkContext.parallelize(arr1)
    val rdd2 = sparkContext.parallelize(arr2)
    //通过相同的键将不同的RDD关联起来，如果键不相同，元素将不会被关联
    val rdd3 = rdd1.join(rdd2)
    rdd3.foreach(println(_))
  }

}
