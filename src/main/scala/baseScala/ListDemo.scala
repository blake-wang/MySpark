package baseScala

/**
 * Created by JSJSB-0071 on 2017/7/22.
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


  }


}
