package Test

/**
  * Created by wanglei on 2017/7/18.
  */
object ForArrayDemo {
  def main(args: Array[String]): Unit = {
    //初始化一个数组
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8)
    //    val arr1 = new Array[Int](6)
    //增强for循环
    for (i <- arr)
      println(i)


    //好用的until会生成一个Range
    //reverse是将前面生成的range反转
    for (i <- (0 until arr.length).reverse) {
      println(arr(i))
    }
  }

}
