package baseSpark.transformationAndaction

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * sortByKey
  * 案例：按照学生的分数进行排序
  */
object sortByKeyDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkConntext = new SparkContext(sparkConf)
    val arr = Array((97, "张宁"), (59, "wanglei"), (88, "志超"), (69, "aixu"))
    val tupleRDD = sparkConntext.parallelize(arr)
    //通过键来排序，默认是升序排序，第一个参数如果是false，就是降序排序
    val result = tupleRDD.sortByKey(true)
    result.foreach(println(_))

  }
}
