package baseScala

/**
  * Created by bigdata on 17-11-6.
  */
class forDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    for (i <- arr) {
      println(i)
    }
  }
}
