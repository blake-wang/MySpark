package baseSpark.UDAF_Demo

import org.apache.avro.generic.GenericData.StringType
import org.apache.spark.sql.Row
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bigdata on 18-1-23.
  * UDF:函数的输入是一条具体的数据记录，实现上讲就是普通的scala函数-只不过需要注册
  * UDAF:用户自定义的聚合函数，函数本身作用于数据集合，能够在具体操作的基础上进行自定义操作
  */
object demo1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val hiveContext = new HiveContext(sparkContext)

    //从集合生成RDD
    val bigData = Array("Spark", "Hadoop", "Flink", "Spark", "Hadoop", "Flink", "Spark", "Hadoop", "Flink", "Spark", "Hadoop", "Flink")
    val bigDataRDD = sparkContext.parallelize(bigData)

    //从RDD生成dataFrame
    val bigDataRowRDD = bigDataRDD.map(line => Row(line))
    val structType = new StructType().add("name", DataTypes.StringType)
    val bigDataDF = hiveContext.createDataFrame(bigDataRowRDD, structType)

    bigDataDF.registerTempTable("bigDataTable")

    //注册自定义函数，用来计算字符串的长度
    hiveContext.udf.register("computeLength", (input: String) => input.length)
    //
    hiveContext.sql("select name,computeLength(name) as length from bigDataTable").show()


    //注册自定义聚合函数
    hiveContext.udf.register("WordCount", new MyUDAF)
    val res = hiveContext.sql("select name,WordCount(name),computeLength(name) from bigDataTable group by name")
    res.show()




  }

}
