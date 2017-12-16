package baseScala.forDemo

/**
  * Created by wanglei on 2017/12/16.
  */
object forDemo {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)

    for (t <- a) {
      println(t)
    }
  }
}
