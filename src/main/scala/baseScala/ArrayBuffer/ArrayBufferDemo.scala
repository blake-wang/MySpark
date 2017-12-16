package baseScala.ArrayBuffer

import scala.collection.mutable.ArrayBuffer

/**
  * Created by JSJSB-0071 on 2017/7/22.
  * ArrayBuffer
  * 类似于ArrayList这种长度可变的集合
  *
  * 使用+=操作符，可以添加一个元素，或者多个元素
  * 使用++=操作符，可以添加其他集合中的所有元素
  *
  * Cannot resolve reference forForArrayBuffer with such signature
  * 无法解决这样的签名参考forForArrayBuffer
  * 如果出现这个错误提示，肯定是数据类型错了，不匹配
  */
object ArrayBufferDemo {

  //变长数组(数组缓冲)
  //如果想使用数组缓冲,需要导入scala.collection.mutable.ArrayBuffer
  val ab1 = new ArrayBuffer[Int]()
  val ab2 = new ArrayBuffer[Any]()
  val ab3 = ArrayBuffer(1, "黑子", Array(1, 2, 3))
  val ab4 = ArrayBuffer(Array[Any](1, 2, 3), Array[Any]("haha", "hehe", "heihei"))


  def main(args: Array[String]) {
    //ArrayBuffer的泛型是Int
    //追加1到ab1
    ab1.+=(1)
    //追加2到ab1
    ab1 += 2
    //++=是把Array(9,8)中的元素9和8取出加入到ab1
    ab1 ++= (Array(9, 8))
    println(ab1)

    println("---------------")

    //ArrayBuffer的泛型是Any ，是所有类型的父类，允许加入任何类型的元素
    ab2.+=(3)
    ab2 += 4
    ab2 += "哈哈"
    //++=是把Array(9,8)中的元素9和8取出加入到ab2
    ab2 ++= (Array(9, 8))
    //+=是把Array(123,456)这个数据追加到ab2
    ab2.+=(Array(123, 456))
    println(ab2)

    println("---------------")
    println(ab3)

    //        forArrayBuffer(ab3)
    forForArrayBuffer(ab4)
  }


  //增强for循环
  def foreachArrayBufferDemo(ab: ArrayBuffer[Any]): Unit = {
    for (i <- ab) {
      println(i)
    }
  }

  //for循环
  //这个因为数据类型不统一，出现问题
  def forArrayBuffer(ab: ArrayBuffer[Any]) = {
    for (i <- 0 to ab.length - 1) {
      println(ab(i))
//      if (i == ab.length - 1) {
//        for (j <- ab(i)) {
//          println(j)
//        }
//      }
    }
  }

  //嵌套for循环,这个不同类型数据的嵌套循环一定要注意
  def forForArrayBuffer(ab: ArrayBuffer[Array[Any]]) = {
    for (i <- ab) {
      for (j <- i) {
        println(j)
      }
    }
  }

}
