package baseSpark.rowDemo

import org.apache.spark.sql.Row
/**
  * Created by bigdata on 18-1-3.
  * row
  * 关系数据库中的一行。
  *
  * dataDrame就是由一行一行的Row组成的
  */
object rowDemo {
  def main(args: Array[String]): Unit = {
    val row = Row("pyw123456", 5399, "5399M19006", "2018-01-03 12:14:00", null)
    println(row)

    val game_account = row.getString(0)
    println("game_account : " + game_account)

    val game_id = row.getInt(1)
    println("game_id : " + game_id)

    val pkg_id = row(2)
    println("pkg_id : " + pkg_id)

    val active_time = row.getString(3)
    println("active_time : " + active_time)

    val last = row(4)
    println("last : " + last)

  }
}
