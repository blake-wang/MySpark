package Test

import java.text.SimpleDateFormat
import java.util.{Date, Calendar}

/**
  * Created by JSJSB-0071 on 2017/7/20.
  */
object DateDemo {
  def main(args: Array[String]) {
    testDateFormat
  }


  //测试dateFormat
  def testDateFormat(): Unit = {
    val currentDay = "2017-07-20"
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date: Date = dateFormat.parse(currentDay)
    //parse是把一个格式化的日期字符串解析成一个date对象
    val cal: Calendar = Calendar.getInstance()
    cal.setTime(date)
    cal.add(Calendar.DATE, -1)
    val yesterday = dateFormat.format(cal.getTime) //format是把一个date对象格式化成一个字符串
    println(yesterday)
  }

}
