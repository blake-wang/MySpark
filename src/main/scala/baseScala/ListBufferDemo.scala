package baseScala

import scala.collection.mutable.ListBuffer

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object ListBufferDemo {
  //创建一个可变列表，初始有3个元素1，2，3
  val list0 = ListBuffer[Int](1,2,3)
  //创建一个空的可变列表
  val list1 = new ListBuffer[Int]

  def main(args: Array[String]) {
    //向list1中追加元素，注意，没有生成新的list
    list1 += 4
    list1.append(5)
    println(list1)
    //将元素追加到list1的后面，注意，生成了一个新的集合
    val list3 = list1 :+ 5
    println(list3)


    //将list1中的元素追加到list0中，注意，没有生成新的集合
    list0 ++= list1
    println(list0)

    //将list1和list0合并成一个新的ListBuffer，注意，生成了一个集合
    val list2 = list0 ++ list1
    println(list2)
  }
}
