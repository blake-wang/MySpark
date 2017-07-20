package Test

import java.sql.{PreparedStatement, DriverManager, Connection}

/**
 * Created by JSJSB-0071 on 2017/7/19.
 */
object MySqlDemo {
  def main(args: Array[String]) {
    //获取数据
    //    getResultSetFromXiaopeng_BI
    //    getResultSetFrom142


    //插入数据
    insertDataInto142

  }

  def getConn(url: String): Connection = {
    //    val jdbcurl="jdbc:mysql://192.168.20.60:3306/xiaopeng2_bi?user=xiaopeng&password=xiaopeng99&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    //
    //    val url = "jdbc:mysql://192.168.126.142:3306/testScala?user=root&password=hadoop&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
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

  def getResultSetFromXiaopeng_BI() = {
    val jdbcurl = "jdbc:mysql://192.168.20.60:3306/xiaopeng2_bi?user=xiaopeng&password=xiaopeng99&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    val sqlText = "select game_id,parent_channel from bi_gamepublic_basekpi_0425 where game_id=? and parent_channel=?"
    val conn: Connection = getConn(jdbcurl)
    val ps: PreparedStatement = conn.prepareStatement(sqlText)
    ps.setInt(1, 2948)
    ps.setString(2, "3aaqy")
    val result = ps.executeQuery()
    println(result.toString)
    while (result.next()) {
      //      result.toString
      //      val game_id = result.getInt("game_Id")
      //从数据库中取出的结果集 ，列的角标是从1 开始的
      val game_id = result.getInt(1)
      val parent_channel = result.getString("parent_channel")
      println("game_id: " + game_id + " , parent_channel :" + parent_channel)
    }
    ps.close()
  }


  //连接到142机器的数据库  ，连接之前记得一定要关闭防火墙 ，要么连接不到
  def getResultSetFrom142() = {
    val url = "jdbc:mysql://192.168.126.142:3306/testScala?user=root&password=hadoop&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    val sqlText = "select name from test1 where id=? or id=?"
    val conn: Connection = getConn(url)
    val ps: PreparedStatement = conn.prepareStatement(sqlText)
    ps.setInt(1, 1)
    ps.setInt(2, 2)
    val result = ps.executeQuery()
    println(result.toString)
    while (result.next()) {
      //      result.toString
      //      val game_id = result.getInt("game_Id")
      //从数据库中取出的结果集 ，列的角标是从1 开始的
      val name = result.getString(1)
      println("name: " + name)
    }
    ps.close()
  }

  //向数据库中插入数据   --插入数据这里有问题，在研究研究
  def insertDataInto142() = {
    val url = "jdbc:mysql://192.168.126.142:3306/testScala?user=root&password=hadoop&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false"
    val sqlText = "insert into  test1(id,name) values(?,?)"
    //    val sqlText = "insert into  test1(id,name) values (111,'123123')"
    //    val t = "insert into bi_gamepublic_actions(publish_date,child_game_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
    val conn: Connection = getConn(url)
    val ps: PreparedStatement = conn.prepareStatement(sqlText)
    ps.setInt(1, 999)
    ps.setString(2, "wanglei")

    //这个方法两种语句都可以执行
    // insert into  test1(id,name) values(？,？)   执行这个语句 ps要设置 每一位？处的值
    // insert into  test1(id,name) values(19,'909090')  执行这个语句 ，ps 就不能再用setInt，用了会报错
    ps.execute()


    //下面这个方法只能执行 这种sql语句    >>就不要中这个方法
    //val sqlText = "insert into  test1(id,name) values(19,'909090')"
    //ps.execute(sqlText)
    ps.close()


  }

}
