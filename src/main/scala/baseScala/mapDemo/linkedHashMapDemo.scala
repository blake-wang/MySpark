package baseScala.mapDemo

import scala.collection.mutable

/**
  * Created by wanglei on 2017/12/18.
  * 默认的map是不维护键插入的顺序的
  * LinkedHashMapDemo会帮我们维护键插入的顺序，
  */
object linkedHashMapDemo {
  def main(args: Array[String]): Unit = {

    //默认的map是不维护插入的顺序的
    val m1 = new mutable.HashMap[String, Int]()
    m1("wanglei") = 78
    m1("aixu") = 26
    m1("zhaorunjun") = 30
    m1("renzhichao") = 67
    println(m1)

    val m2 = new mutable.LinkedHashMap[String,Int]()
    m2("wanglei") = 78
    m2("aixu") = 26
    m2("zhaorunjun") = 30
    m2("renzhichao") = 67
    println(m2)
  }
}
