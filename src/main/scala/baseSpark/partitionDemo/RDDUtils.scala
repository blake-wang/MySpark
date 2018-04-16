package baseSpark.partitionDemo

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by wanglei on 2017/12/22.
  * spark查看分区元素数工具
  *
  * spark中也有可能出现数据倾斜问题（如join等，当key有大部分相同时（如像hive数据倾斜那样join的字段很多为null））
  * 所以需要查看各分区的元素数据来判断数据各分区分布情况。
  * 以下是查看分区元素数的党法
  */
object RDDUtils {

  def getPartitionCounts[T](sparkContext: SparkContext, rdd: RDD[T]): Array[Long] = {
    sparkContext.runJob(rdd, getIteratorSize _)
  }

  def getIteratorSize[T](iterator: Iterator[T]): Long = {
    var count = 0L
    while (iterator.hasNext) {
      count += 1L
      //iteror这里，如果要循环遍历，要继续next一次
      iterator.next()
    }
    count
  }

}
