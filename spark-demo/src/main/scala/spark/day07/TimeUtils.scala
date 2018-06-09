package cn.wanglei.spark.day07

import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Created by wanglei on 2017/6/8.
  */
object TimeUtils {
  val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  val calendar = Calendar.getInstance()

  def apply(time: String): Long = {
    calendar.setTime(simpleDateFormat.parse(time))
    calendar.getTimeInMillis
  }

  def getCertainDayTime(amount: Int): Long = {
    //在时间的基础上加上或减去传进来的天数
    calendar.add(Calendar.DATE, amount)
    val time = calendar.getTimeInMillis
    //把时间复原
    calendar.add(Calendar.DATE, -amount)
    time
  }
}

