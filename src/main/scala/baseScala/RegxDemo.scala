package baseScala

import scala.util.matching.Regex

/**
  * Created by bigdata on 17-11-24.
  */
object RegxDemo {
  def main(args: Array[String]): Unit = {

    val str = "\\d{4,5}[MQ]\\d{4,7}[a-z]?"
    val pattern = new Regex(str)
    val pkg_id = "5400M24001i8885229i"
    val pkg_id2 = "5400M24001i"
    val pkg_id3 = "5400M4001"
    val pkg_id4 = "5400Q4001"
    val pkg_id5 = "5400W4001"
    val pkg_id6 = "1234Q1234123c"
    val pkg_id7 = "12345Q1234123c"
    val pkg_id8 = "1234Q1234567z"

    println((pattern findAllIn pkg_id).mkString(","))
    val result = pkg_id.matches(str)
    println(result)
    val result2 = pkg_id2.matches(str)
    println(result2)
    val result3 = pkg_id3.matches(str)
    println(result3)
    val result4 = pkg_id4.matches(str)
    println(result4)
    val result5 = pkg_id5.matches(str)
    println(result5)
    val result6 = pkg_id6.matches(str)
    println(result6)
    val result7 = pkg_id7.matches(str)
    println(result7)
    val result8 = pkg_id8.matches(str)
    println(result8)
  }

}
