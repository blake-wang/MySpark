package baseSpark


import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by JSJSB-0071 on 2017/7/24.
  */
object dataFrameDemo {

  def main(args: Array[String]) {
    //    rddToDataFrameFirst()
    rddToDataFrameSecond()
  }

  //第二种方式，通过StructType的方式创建DataFrame
  def rddToDataFrameSecond(): Unit = {
    val conf = new SparkConf().setAppName("sqlDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val personRdd = sc.textFile("hdfs://192.168.33.21:9000/people.txt").map(_.split(","))
    //通过StructType，直接指定每个字段的schema
    val schema = StructType(
      List(StructField("id", IntegerType)
        , StructField("name", StringType),
        StructField("age", IntegerType)
      )
    )
    //将Rdd映射到rowRDD
    val rowRDD = personRdd.map(row => Row(row(0).toInt, row(1).trim, row(2).toInt))
    //将schema信息应用到rowRDD上
    val personDataFrame = sqlContext.createDataFrame(rowRDD, schema)

    personDataFrame.write.json("hdfs://192.168.33.21:9000/json.txt")

    //注册表
    personDataFrame.registerTempTable("person")
    //执行SQL
    sqlContext.sql("select * from person").show()


  }

  //第一种方式，用toDF方法生成DataFrame的方式
  def rddToDataFrameFirst(): Unit = {
    val conf = new SparkConf().setAppName("sqlDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val personRdd = sc.textFile("hdfs://192.168.33.21:9000/people.txt").map(line => {
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

