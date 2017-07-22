package baseScala

import scala.collection.immutable.HashSet

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object ImmutSetDemo {
  //创建一个不可变的set
  val set1 = new HashSet[Int]()

  def main(args: Array[String]) {

    //将元素和set1合并生成一个新的set，原有set不变
    println(set1)
    val set2 = set1 + 4 + 5
    println(set1)
    println(set2)

    //将一个新的set中的元素添加到当前set，生成新的set
    val set3 = set1 ++ Set(5, 6, 7)
    println(set1)
    println(set3)

    //set中的元素不能重复    //添加重复元素添加不进去
    val set0 = Set(1, 1, 2, 2, 3) //set是去重的
    println(set0)
    val set4 = Set(4) ++ Set(5, 6, 7)
    println(set4)
    val set5 = set4 ++ Set(4)
    println(set5)

  }


}
