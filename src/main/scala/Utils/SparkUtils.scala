package Utils

import java.sql.Connection
import java.util.Properties

import constant.Constants
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.{Row, RowFactory}
import org.apache.spark.{SparkConf, SparkContext}
import util.ConfigurationUtil

import scala.collection.mutable.ArrayBuffer

/**
  * Created by kequan on 2/22/17.
  */
object SparkUtils {
  def setMaster(conf: SparkConf) {
    val local = ConfigurationUtil.getBoolean(Constants.SPARK_LOCAL)
    if (local) conf.setMaster("local[2]")
  }

  /**
    * 读取bi 表 并注册相应的表
    *
    * @param tabName
    * @param hiveContext
    * 注意： 该方法读取的是整张表，所以只能用于读取小表，表的数据数据过大会导致内存溢出
    */
  def readBiTable(tabName: String, hiveContext: HiveContext) = {
    val properties = new Properties()
    properties.put("driver", ConfigurationUtil.getProperty(Constants.JDBC_DRIVER))
    properties.put("user", ConfigurationUtil.getProperty(Constants.JDBC_USER))
    properties.put("password", ConfigurationUtil.getProperty(Constants.JDBC_PWD))
    val deptDF = hiveContext.read.jdbc(ConfigurationUtil.getProperty(Constants.JDBC_URL), tabName, properties).persist()
    deptDF.registerTempTable(tabName)
  }

  /**
    * 读取 xiaopeng2 表 并注册相应的表
    *
    * @param tabName
    * @param hiveContext
    * 注意： 该方法读取的是整张表，所以只能用于读取小表，表的数据数据过大会导致内存溢出
    */
  def readXiaopeng2Table(tabName: String, hiveContext: HiveContext) = {
    val properties = new Properties()
    properties.put("driver", ConfigurationUtil.getProperty(Constants.JDBC_DRIVER))
    properties.put("user", ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2_USER))
    properties.put("password", ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2_PWD))
    val deptDF = hiveContext.read.jdbc(ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2_URL), tabName, properties).persist()
    deptDF.registerTempTable(tabName)
  }

  /**
    * 读取 xiaopeng2_faxing 表 并注册相应的表
    *
    * @param tabName
    * @param hiveContext
    * 注意： 该方法读取的是整张表，所以只能用于读取小表，表的数据数据过大会导致内存溢出
    */
  def readXiaopeng2FxTable(tabName: String, hiveContext: HiveContext) = {
    val properties = new Properties()
    properties.put("driver", ConfigurationUtil.getProperty(Constants.JDBC_DRIVER))
    properties.put("user", ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2FX_USER))
    properties.put("password", ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2FX_PWD))
    val deptDF = hiveContext.read.jdbc(ConfigurationUtil.getProperty(Constants.JDBC_XIAOPENG2FX_URL), tabName, properties).persist()
    deptDF.registerTempTable(tabName)
  }

  /**
    * 读取 bi 的bi_gamepublic_active_detail 表 并注册相应的表
    *
    * @param sc
    * @param hiveContext
    * @param startTime
    * @param endTime
    *
    * 可以带时间参数，在时间范围小的情况下，不会造成内出溢出
    */
  def readActiveDeatials(sc: SparkContext, hiveContext: HiveContext, startTime: String, endTime: String) = {

    val conn: Connection = JdbcUtil.getConn();
    val sql = "select game_id,parent_channel,child_channel,ad_label,imei,active_hour from bi_gamepublic_active_detail where date(active_hour)>='startTime' and  date(active_hour)<='endTime'"
      .replace("startTime", startTime).replace("endTime", endTime)
    val stmt = conn.createStatement();
    val results = stmt.executeQuery(sql);
    var rows = new ArrayBuffer[Row]()
    while (results.next()) {
      rows.+=(RowFactory.create(Integer.valueOf(results.getInt(1).toString), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6)));
    }
    val rowsRDD = sc.parallelize(rows);
    val schema = (new StructType).add("game_id", IntegerType).add("parent_channel", StringType).add("child_channel", StringType).add("ad_label", StringType).add("imei", StringType).add("active_hour", StringType)
    hiveContext.createDataFrame(rowsRDD, schema).persist().registerTempTable("bi_gamepublic_active_detail");

  }

  /**
    * 读取 bi 的 bi_gamepublic_regi_detail 表 并注册相应的表
    *
    * @param sc
    * @param hiveContext
    * @param startTime
    * @param endTime
    *
    * 可以带时间参数，在时间范围小的情况下，不会造成内出溢出
    */
  def readRegiDeatials(sc: SparkContext, hiveContext: HiveContext, startTime: String, endTime: String) = {

    val conn: Connection = JdbcUtil.getConn();
    val sql = "select game_id,parent_channel,child_channel,ad_label,imei,regi_hour from bi_gamepublic_regi_detail where date(regi_hour)>='startTime' and  date(regi_hour)<='endTime'"
      .replace("startTime", startTime).replace("endTime", endTime)
    val stmt = conn.createStatement();
    val results = stmt.executeQuery(sql);
    var rows = new ArrayBuffer[Row]()
    while (results.next()) {
      rows.+=(RowFactory.create(Integer.valueOf(results.getInt(1).toString), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6)));
    }
    val rowsRDD = sc.parallelize(rows);
    val schema = (new StructType).add("game_id", IntegerType).add("parent_channel", StringType).add("child_channel", StringType).add("ad_label", StringType).add("imei", StringType).add("regi_hour", StringType)
    hiveContext.createDataFrame(rowsRDD, schema).persist().registerTempTable("bi_gamepublic_regi_detail");
  }

  /**
    * 读取 bi 的 bi_publish_back_performance 表 并注册相应的表
    *
    * @param sc
    * @param hiveContext
    * @param startTime
    * @param endTime
    *
    * 可以带时间参数，在时间范围小的情况下，不会造成内出溢出
    */
  def readPerformance(sc: SparkContext, hiveContext: HiveContext, startTime: String, endTime: String) = {

    val conn: Connection = JdbcUtil.getConn();
    val sql = "select performance_time,medium_channel,ad_site_channel,pkg_code,parent_game_id,child_game_id,pay_water,box_water,main_man,regi_num,pay_type from bi_publish_back_performance where performance_time >='startTime' and  performance_time <='endTime'"
      .replace("startTime", startTime).replace("endTime", endTime)
    val stmt = conn.createStatement();
    val results = stmt.executeQuery(sql);
    var rows = new ArrayBuffer[Row]()
    while (results.next()) {
      rows.+=(RowFactory.create(results.getDate(1).toString, results.getString(2), results.getString(3), results.getString(4), Integer.valueOf(results.getInt(5).toString), Integer.valueOf(results.getInt(6).toString), Integer.valueOf(results.getInt(7).toString), Integer.valueOf(results.getInt(8).toString), results.getString(9), Integer.valueOf(results.getInt(10).toString), results.getString(11)));
    }
    val rowsRDD = sc.parallelize(rows);
    val schema = (new StructType).add("performance_time", StringType).add("medium_channel", StringType).add("ad_site_channel", StringType).add("pkg_code", StringType).add("parent_game_id", IntegerType).add("child_game_id", IntegerType).add("pay_water", IntegerType).add("box_water", IntegerType).add("main_man", StringType).add("regi_num", IntegerType).add("pay_type", StringType)
    hiveContext.createDataFrame(rowsRDD, schema).persist().registerTempTable("bi_publish_back_performance");
  }
}
