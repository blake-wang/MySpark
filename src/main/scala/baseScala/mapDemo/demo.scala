package baseScala.mapDemo

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/**
  * Created by bigdata on 17-12-20.
  */
object demo {
  def main(args: Array[String]): Unit = {
    val arr = new ArrayBuffer[Array[Any]]()

    //    arr += Array(4399, "4399M123")
    arr.+=(Array(4399, "4399M123"))
    arr.+=(Array(4399, "4399M456"))
    arr.+=(Array(4399, "4399M789"))
    arr.+=(Array(4399, "4399M123"))
    for (i <- arr) {
      println(i(0) + " : " + i(1))
    }
    println("-------------")
    for (i <- arr) {
      println(i(0) + " : " + i(1))
    }

    val arr2 = new ArrayBuffer[String]()
    arr2.+=("4399M123")
    arr2.+=("4399M456")
    arr2.+=("4399M789")
    arr2.+=("4399M123")
    println(arr2)
    val arr8 = arr2.distinct
    println(arr2)
    println("arr8 : "+ arr8)

    val arr3 = mutable.HashSet[String]()
    val arr4 =arr3.add("123")
    println("arr4 : "+ arr4)
    arr3.add("456")
    arr3.add("789")
    arr3.add("123")
    arr3.+=("haha")
    arr3.+("heihei")
    println(arr3)
    for (i <- arr3) {
      println(i)
    }
    arr3.clear()
    println(arr3)
    arr3.+=("王磊再来玩一次")
    println(arr3)

  }
}
