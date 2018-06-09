package baseScala.forDemo


/**
  * Created by bigdata on 17-11-6.
  * for 函数
  */
object forDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array[Int](0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    //按角标遍历
    for (i <- 0 until arr.length) {
      println(arr(i))
    }

    for (i <- arr.indices) {
      println(arr(i))
    }
    println("-------------------------------------")

    //按元素遍历
    for (i <- arr) {
      println(i)
    }
    println("-------------------------------------")

    //跳跃遍历
    for (i <- 0 until(arr.length, 2)) {
      println(arr(i))
    }
    println("-------------------------------------")

    //反向遍历，尾部遍历
    for (i <- (0 until arr.length).reverse) {
      println(i)
    }
    println("-------------------------------------")

    //1
    for (i <- 1 to 10) {
      println(i)
    }
    println("-------------------------------------")
    //2   包含头不包含尾
    for (i <- 1 until 10) {
      println(i)
    }

    println("-------------------------------------")
    //3
    for (i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }
    println("-------------------------------------")

  }
}