package baseScala.ArrayBufferDemo

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wanglei on 2017/12/16.
  */
object toArray {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(1, 2, 3, 4, 5)

    println(arr)

    //toArray，生成一个新的array
    val arr2 = arr.toArray
    println(arr)

  }

}
