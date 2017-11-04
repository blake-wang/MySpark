package testregx



/**
  * Created by wanglei on 2017/7/13.
  */
object Regx {
  def main(args: Array[String]): Unit = {

    println(isRequestLog("abc", ".*0800] \"GET /Ssxy/loadComplete[?]p=[\\d|_|a-z|A-Z]+&g=[\\d]+.*"))

  }

  def isRequestLog(log: String, regx: String): Boolean = {
    val p1 = regx.r
    val p1Matches = log match {
      case p1 => true
      case _ => false
    }
    p1Matches
  }

}
