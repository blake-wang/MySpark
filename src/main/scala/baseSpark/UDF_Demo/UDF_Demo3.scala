package baseSpark.UDF_Demo

import java.util.Properties

import Utils.JedisUtil
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.{SparkConf, SparkContext}
import redis.clients.jedis.{Jedis, JedisPool}
import udf.TestMd5

/**
  * Created by bigdata on 18-1-25.
  */
object UDF_Demo3 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val hiveContext = new HiveContext(sparkContext)

    val url = "jdbc:mysql://192.168.20.60:3306/xiaopeng2_bi?user=xiaopeng&password=xiaopeng99&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    val tableName = "bi_publish_back_divide"
    val driver = "com.mysql.jdbc.Driver"
    val user = "xiaopeng"
    val password = "xiaopeng99"

    val prop = new Properties()
    prop.setProperty("driver", driver)
    prop.setProperty("user", user)
    prop.setProperty("password", password)

    val df = hiveContext.read.jdbc(url, tableName, prop)
    df.show()
    df.registerTempTable("divide")


    hiveContext.udf.register("md5", new TestMd5(), DataTypes.StringType)

    val df2 = hiveContext.sql("select *,md5(parent_game_id) from divide")
    df2.show()

    val rdd = df2.rdd
    rdd.map(line => {
      println("haha - :" + line)

      val pool: JedisPool = JedisUtil.getJedisPool()
      val jedis: Jedis = pool.getResource;
      jedis.select(6)
      jedis.set("haha","123")

    })


    rdd.foreach(line=>{
      println("foreach - :" + line)

      val pool: JedisPool = JedisUtil.getJedisPool()
      val jedis: Jedis = pool.getResource;
      jedis.select(6)
      jedis.set("haha","123")
    })


  }

}
