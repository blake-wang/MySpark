package MyTestCode

import java.sql.{PreparedStatement, DriverManager, Connection}

/**
 * Created by JSJSB-0071 on 2017/7/19.
 */
object MySqlDemo {
  def main(args: Array[String]) {
    val sqlText = "select name from test1 where id=? and id=?"
    val conn:Connection = getConn()
    println("1")
    val ps:PreparedStatement = conn.prepareStatement(sqlText)
    println("2")
    ps.setInt(1,1)
    ps.setInt(2,4)
    val result = ps.executeQuery()
    println("3")
    while(result.next()){
      val name = result.getString(0)
      println(name)
    }
    ps.close()
    println("4")

  }

  def getConn(): Connection = {
    val url = "jdbc:mysql://192.168.126.142/testScala?user=root&password=hadoop&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    val driver = "com.mysql.jdbc.Driver"

    try {
      Class.forName(driver)
      return DriverManager.getConnection(url)
    }
    catch {
      case ex: Exception => {
        println("获取数据库连接错误：Exception= " + ex)
      }
        return null
    }
  }

}
