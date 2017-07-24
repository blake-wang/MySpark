package baseSpark


import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by JSJSB-0071 on 2017/7/24.
 */
object dataFrameDemo {

  def main(args: Array[String]) {

  }

  def rddToDataFrameSecond(): Unit ={
    val conf = new SparkConf().setAppName("sqlDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val personRdd = sc.textFile("hdfs://192.168.20.176:9000/xx.txt").map(_.split(","))
    //直接指定每个字段的schema
  }

  //第一种生成DataFrame的方式
  def rddToDataFrameFirst(): Unit = {
    val conf = new SparkConf().setAppName("sqlDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val personRdd = sc.textFile("hdfs://192.168.20.176:9000/xx.txt").map(line => {
      val fields = line.split(",")
      Person(fields(0).toLong, fields(1), fields(2).toInt)
    })
    //导入隐式转换，才会有 toDF这个方法，如果不导入无法将RDD转换成DataFrame
    import sqlContext.implicits._
    val personDf = personRdd.toDF()
    personDf.registerTempTable("person")
    sqlContext.sql("select * from person order by age desc").show()
  }

}

//这个case class一定要放在外面
case class Person(id: Long, name: String, age: Int)

