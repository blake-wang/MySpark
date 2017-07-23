package baseSpark

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object RddDemo {
  def main(args: Array[String]) {
    //    readFileFromHdfs
    arrayToRdd

  }

  //通过HDFS支持的文件系统创建RDD，RDD里面没有真正要计算的数据，只是记录了一下元数据
  def readFileFromHdfs(): Unit = {
    val conf = new SparkConf().setAppName("wc").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //读取hdfs上面的文件，并将计算结果输出到hdfs,textFile方法会生成一个Rdd
    val rdd1 = sc.textFile("hdfs://192.168.20.176:9000/in")
    val rdd2 = rdd1.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    rdd2.saveAsTextFile("hdfs://192.168.20.176:9000/out8")

  }

  //通过scala集合或数组以并行化的方式创建RDD
  def arrayToRdd(): Unit = {
    val conf = new SparkConf().setAppName("wc").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //把一个数组转换成ParallelCollectionRDD[0]    //也可以是List等其他集合
    val rdd1 = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 5)
    println("rdd1 : " + rdd1)
    //把rdd1转换成MapPartitionsRDD[1]
    val rdd2 = rdd1.map(_ * 10)
    println("rdd2 : " + rdd2)
    //过滤出小于50的元素MapPartitionsRDD[2]
    val rdd3 = rdd2.filter(_ < 50)
    println("rdd3 : " + rdd3)
    //把计算结果转Rdd换成一个数组
    val rdd4 = rdd3.collect()
    println(rdd4(3))
    println(rdd4.toBuffer)
  }

}
