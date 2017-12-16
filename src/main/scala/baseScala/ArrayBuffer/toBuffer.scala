package baseScala.ArrayBuffer

/**
  * Created by wanglei on 2017/12/16.
  */
object toBuffer {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    println(arr)
    //生成一个新的arraybuffer
    val arr2 = arr.toBuffer
    println(arr2)
  }

}
