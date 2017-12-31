package baseSpark.transformationAndaction.actionDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/12/31.
  * collect
  *
  * 将分布在远程集群上的RDD的数据拉取到本地
  *
  * 这种方式，一般不建议使用，因为如果rdd中的数据量比较大的话，比如超过1万条，
  * 那么性能会比较差，因为要从远程走大量的网络传输，将数据获取到本地，
  * 此外，除了性能差，还可能在rdd中数据量特别大的情况下，发生oom异常，内存溢出
  *
  */
object collectDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //parallelize传入的集合类型是seq，seq的子类包含Array,ArrayBuffer,List
    val rdd = sparkContext.parallelize(arr)

    //rdd2是RDD类型
    val rdd2 = rdd.map(_ * 2)
    println(rdd2)
    for (i <- rdd2) {
      println(i)
    }
    //通过collect将rdd2从集群拉取到本地生成result，result是数组类型
    val result = rdd2.collect()
    println(result)
    for (i <- result) {
      println(i)
    }

  }
}
