package baseSpark.transformationAndaction.actionDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * countByKey
  * 统计每个key对应的元素的个数
  *
  * 案例：统计每个班级的学生人数
  */
object countByKeyDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr1 = Array(("class1", "wanglei"), ("class2", "李彦宏"), ("class1", "aixu"), ("class1", "志超"), ("class2", "马化腾"), ("class2", "马云"), (4, "王健林"))
    val rdd = sparkContext.parallelize(arr1)
    //countByKey返回的是Map，并且不需要传入参数
    val result = rdd.countByKey
    println(result)
  }

}
