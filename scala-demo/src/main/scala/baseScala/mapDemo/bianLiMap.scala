package baseScala.mapDemo

import scala.collection.mutable

/**
  * Created by wanglei on 2017/12/18.
  * 遍历map
  */
object bianLiMap {
  def main(args: Array[String]): Unit = {
    val m1 = mutable.Map[String, Int]("wanglei" -> 12, "aixu" -> 26, "wangxin" -> 44)

    //遍历map的entrySet
    for ((key, value) <- m1) {
      println(key + " : " + value)
    }
    //遍历map的key
    for (key <- m1.keySet) {
      println(key)
    }
    //遍历map的value
    for (value <- m1.values) {
      println(value)
    }
    //生成新map，反转key和value
    val m2 = for ((key, value) <- m1) yield (value, key)
    println(m2)
  }

}
