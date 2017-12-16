package baseScala.ArrayBuffer

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wanglei on 2017/12/16.
  */
object remove {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(arr)
    //移除指定角标的元素
    arr.remove(4)
    println(arr)
    arr.remove(4, 3)
    println(arr)
  }

}
