package cn.wanglei.spark.day07

import org.apache.commons.lang3.time.FastDateFormat

/**
  * Created by wanglei on 2017/6/8.
  */
object FilterUtils {

  //FastDateFormat是线程安全的  SimpleDateFormat是线程不安全的
  //括号中的第二个参数E，表示的是星期               2016年2月1日,星期一,22:44:13
  val dateFormat = FastDateFormat.getInstance("yyyy年MM月dd日,E,HH:mm:ss")

  //根据时间过滤
  def filterByTime(fields: Array[String], startTime: Long, endTime: Long): Boolean = {
    val time = fields(1)
    val logTime = dateFormat.parse(time).getTime
    logTime >= startTime && logTime < endTime
  }

  //根据类型过滤
  def filterByType(fields: Array[String], eventType: String): Boolean = {
    val _type = fields(0)
    eventType == _type
  }

  //根据类型过滤，筛选出日活跃用户，第二个参数是可变参数
  def filterByTypes(fields: Array[String], eventTypes: String*): Boolean = {
    val _type = fields(0)
    for (et <- eventTypes) {
      if (et == _type) {
        return true
      }
    }
    false
  }

  def filterByTypeAndTime(fields: Array[String], eventType: String, beginTime: Long, endTime: Long): Boolean = {
    val _type = fields(0)
    val _time = fields(1)
    val logTime = dateFormat.parse(_time).getTime
    eventType == _type && logTime >= beginTime && logTime < endTime

  }

}
