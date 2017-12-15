package baseSpark

import org.apache.spark.SparkConf

/**
  * Created by bigdata on 17-12-13.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    val env = sparkConf.getExecutorEnv
    println(env)
  }

}
