package baseScala

import scala.collection.mutable

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object MmutMapDemo {
  //创建一个可变的HashMap
  val map1 = new mutable.HashMap[String, Int]()

  def main(args: Array[String]) {
    //向map中添加数据
    map1("spark") = 1
    map1 += (("hadoop", 2))
    map1.put("scala",3)
    println(map1)

    //从map中移除元素
    map1 -= "spark"
    map1.remove("hadoop")
    println(map1)
  }

}
