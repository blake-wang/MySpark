package baseScala

import scala.collection.mutable.ArrayBuffer

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object ArrayBufferDemo {

  //变长数组(数组缓冲)
  //如果想使用数组缓冲,需要导入scala.collection.mutable.ArrayBuffer
  val ab1 = new ArrayBuffer[Int]()
  val ab2 = new ArrayBuffer[Any]()
  val ab3 = ArrayBuffer(1, "黑子", Array(1, 2, 3))

  def main(args: Array[String]) {
    //ArrayBuffer的泛型是Int
    ab1.+=(1)
    ab1 += 2 //把2追加到ab1中，这种情况可以使用+=，也可以使用.+=
    ab1 ++= (Array(9, 8)) //++=是把Array(9,8)中的元素9和8取出加入到ab1,这种情况只能有++=，不能用.+=()
    println(ab1)

    println("---------------")

    //ArrayBuffer的泛型是Any
    ab2.+=(3)
    ab2 += 4 //把4追加到ab2中，这种情况可以使用+=，也可以使用.+=
    ab2 += "哈哈" //也可以追加字符串到ab2
    ab2 ++= (Array(9, 8))
    ab2.+=(Array(9, 8)) //++=是把Array(9,8)中的元素9和8取出加入到ab2
    //.+=()是把Array(9,8)这个对象追加进ab2
    println(ab2)

    println("---------------")
    println(ab3)

    //forArrayBuffer(ab3)
  }


  //增强for循环
  def foreachArrayBufferDemo(ab: ArrayBuffer[Any]): Unit = {
    for (i <- ab) {
      println(i)
    }
  }

  //for循环
  def forArrayBuffer(ab: ArrayBuffer[Any]) = {
    for (i <- 0 to ab.length - 1) {
      println(ab(i))
    }
  }

}
