package baseScala.ArrayBufferDemo

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wanglei on 2017/12/16.
  * insert
  * 使用insert函数可以在指定位置插入元素
  * 但是这种操作效率很低，因为需要移动制动位置后的所有元素
  */
object insert {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(1, 2, 3, 4, 5)
    println(arr)
    //指定在角标位置插入900
    arr.insert(3, 900)
    println(arr)
    //在指定角标位置插入 77，66
    arr.insert(4, 77, 66)
    println(arr)
  }

}
