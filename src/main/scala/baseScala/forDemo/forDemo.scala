package baseScala.forDemo


/**
  * Created by bigdata on 17-11-6.
  * for 函数
  */
object forDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array[Int](1, 2, 3, 4, 5)
    for (i <- 0 until arr.length) {
      println(arr(i))
    }
    //    for (i <- arr) {
    //      println(i)
    //    }

    //1
    for (i <- 1 to 10) {
      println(i)
    }

    for (i <- 1 until 10) {
      println(i)
    }
    //2

    //3
    for (i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }


  }
}