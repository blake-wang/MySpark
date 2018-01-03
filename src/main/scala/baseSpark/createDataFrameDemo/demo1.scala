package baseSpark.createDataFrameDemo

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/1/2.
  * 通过json文件创建dataFrame
  */
object demo1 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$","")).setMaster("local[1]")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val df = sqlContext.read.json("F:\\IdeaProjects\\MySpark\\src\\testData\\jsonData.txt")
    //基本操作
    df.show()
    df.printSchema()
    df.select("author").show()
//    dataFrame.filter(dataFrame['author']!="tobe").show()
    df.groupBy("author").count().show()

    //执行SQL命令
    df.registerTempTable("test")
    df.sqlContext.sql("select * from test").show()

    //通过代码创建DataFrame
//    val rdd = sparkContext.parallelize([])
//    val anotherPeopleRDD = sparkContext.parallelize(Row[{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}])






  }

}
