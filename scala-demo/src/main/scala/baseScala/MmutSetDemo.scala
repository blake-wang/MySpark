package baseScala

import scala.collection.mutable

/**
  * Created by JSJSB-0071 on 2017/7/22.
  */
object MmutSetDemo {

  //创建一个可变的HashSet
  val set1 = new mutable.HashSet[Int]()

  def main(args: Array[String]) {
    //向HashSet中添加元素   --不生成新的set
    println(set1)
    set1 += 2
    println(set1)

    //add等价于+=
    set1.add(4)
    println(set1)

    // ++=添加进一个set中的所有元素
    set1 ++= mutable.Set(1, 3, 5)
    println(set1)

    //删除一个元素
    set1 -= 5
    println(set1)
    set1.remove(1) //如果存在就删除，不存在也不报错
    println(set1)


  }
}
