package baseScala.listDemo

import scala.collection.mutable

/**
  * Created by wanglei on 2017/12/20.
  * LinkedList
  * 代表一个可变的列表，
  * 使用elem可以引用其头部，使用next可以引用其尾部
  *
  */
object LinkedListDemo {
  def main(args: Array[String]): Unit = {
    val list = mutable.LinkedList(1, 2, 3, 4, 5)

    println(list)
    //elem取第一个元素
    println(list.elem)
    //tail取出除了第一个元素的其他元素
    println(list.tail)

    //案例：使用while循环将LinkedList中的每个元素都乘以2
    val list2 = mutable.LinkedList(1, 2, 3, 4, 5)
    var currentList = list2
    while (currentList != Nil) {
      currentList.elem = currentList.elem * 2
      currentList = currentList.next
    }
    println(list2)

    //案例：使用while循环将LinkedList中,从第一个元素开始，每隔一个元素乘以2
    val list3 = mutable.LinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var currentList2 = list3
    var first = true
    while (currentList2 != Nil && currentList2.next != Nil) {
      if (first) {
        currentList2.elem = currentList2.elem * 2
        first = false
      }
      currentList2 = currentList2.next.next
      if (currentList2 != Nil) currentList2.elem = currentList2.elem * 2
    }
    println(list3)

  }
}
