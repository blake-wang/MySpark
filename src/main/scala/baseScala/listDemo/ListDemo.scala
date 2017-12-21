package baseScala.listDemo

import scala.collection.immutable.Nil

/**
  * List
  * 代表一个不可变的列表
  * List有head和tail，head代表List的第一个元素，tail代表第一个元素之后的所有元素
  * List有特殊的::操作符，可以用于将head和tail合并成一个List，0::List
  * 如果一个List只有一个元素，那它的head就是这个元素，他的tail就是Nil
  *
  */
object ListDemo {
  //创建一个不可变的集合
  val list0 = List(7, 8, 9)
  val list1 = List(1, 2, 3)

  def main(args: Array[String]) {
    println(list1)
    //将0插入到list1的前面产生一个新的集合
    val list2 = 0 :: list1
    println(list2)
    val list3 = list1.::(0)
    println(list3)

    //将4插入到list1的后面产生一个新的集合
    val list4 = list1 :+ 4
    println(list4)

    //将两个list合并成一个新的List
    val list5 = list1 ++ list0
    println(list5)


    //递归
    decorator(List(1, 2, 3, 4), "tt-")

  }

  //用递归函数来给List中每个元素都加上指定前缀，并打印加上前缀的元素
  def decorator(list: List[Int], prefix: String): Unit = {
    //scala中的 Nil ，与java中的null是一个意思
    if (list != Nil) {
      println(prefix + list.head)
      decorator(list.tail, prefix)
    }
  }
}
