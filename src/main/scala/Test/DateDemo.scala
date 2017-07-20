package Test

import java.text.SimpleDateFormat
import java.util.{Date, Calendar}

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
object DateDemo {
  def main(args: Array[String]) {
    val str = "2017-05-12"
    val sdf = new SimpleDateFormat("yyyy-MM-dd")
    val date = sdf.parse(str)
    val sdf2 = sdf.format(date)
    println(date)
    println(sdf2)

//    val cal = Calendar.getInstance();
//    cal.setTime(date)

    val date2 = new Date(2017,12,9);
    println(date2.getTime)


  }

}
