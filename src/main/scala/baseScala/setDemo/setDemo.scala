package baseScala.setDemo

import scala.collection.mutable

/**
  * Created by wanglei on 2017/12/21.
  * Set
  * 代表没有重复元素的集合
  * 将重复元素加入Set是没有用的，而且Set是不保证插入顺序的，也就是说，Set中的元素是乱序的
  *
  * LinkedHashSet会用一个链表维护插入顺序
  * SortedSet会自动根据Key来进行排序
  */
object setDemo {
  def main(args: Array[String]): Unit = {
    //HashSet  元素不重复而且无序
    val s = new mutable.HashSet[String]
    s.+=("wanglei")
    s.+=("aixu")
    s.+=("aixu")
    s.+=("4399M1205")
    println(s)

    //LinkedHashSet 元素不重复，按插入顺序排序
    val ls = new mutable.LinkedHashSet[String]()
    ls.+=("wanglei")
    ls.+=("aixu")
    ls.+=("aixu")
    ls.+=("4399M1205")
    println(ls)

    //SortedHashSet 会自动根据key来进行排序
    val ss = mutable.SortedSet[String]("wanglei", "aixu", "4399M1205", "aixu", "2399M1205")
    ss.+=("heihei")
    println(ss)


  }
}
