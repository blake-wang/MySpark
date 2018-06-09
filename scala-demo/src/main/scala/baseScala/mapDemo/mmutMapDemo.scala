package mapDemo

import scala.collection.mutable

/**
  * map
  * 分为
  * 可变的Map ：scala.collection.mutable
  * 不可变的Map ： scala.collection.immutable
  */
object mmutMapDemo {


  def main(args: Array[String]) {
    val m1 = mutable.Map[String, Int]("wanglei" -> 12, "aixu" -> 26)
    //更新Map的元素
    println(m1("wanglei"))
    m1("wanglei") = 99
    println(m1("wanglei"))
    //增加多个元素  用 .+=  或者 += ，加入后是无序的
    m1 += ("wangxin" -> 40, "lihui" -> 77)
    m1.put("hadoop", 123456)
    println(m1)
    //移除元素  直接用 "key"
    m1 -= "wangxin"
    m1.remove("lihui")
    println(m1)


    //getValue
    //create
    //chuangJianFangShi
  }

  private def getValue = {
    val m1 = mutable.Map[String, Int]("wanglei" -> 12, "aixu" -> 26)
    //获取指定key对应的value，如果key不存在，会报错
    val wage = m1("wanglei")
    println(wage)
    val aage = m1("aixu")
    println(aage)
    //使用contains函数检查key是否存在
    val age1 = if (m1.contains("wanglei")) m1("wanglei") else 0
    println(age1)
    //getOrElse函数
    val age2 = m1.getOrElse("wangleii", 0)
    println(age2)
  }

  def modifyValue = {
    val m1 = mutable.Map[String, Int]("wanglei" -> 12, "aixu" -> 26)
    //可变的map，可以通过key来修改值
    m1("wanglei") = 24
    println(m1("wanglei"))
  }

  private def chuangJianFangShi = {
    //创建方式1
    val m2 = Map[String, Int](("wanglei", 1), ("aixu", 2))
    println(m2)
    //创建方式2
    val m3 = Map("wanglei" -> 1, "aixu" -> 2)
    println(m3)
    //创建方式3
    val m4 = new mutable.HashMap[String, Int]()
  }

  private def create = {
    //创建一个可变的HashMap
    val map1 = new mutable.HashMap[String, Int]()

    //向map中添加数据
    map1("spark") = 1
    map1 += (("hadoop", 2))
    map1.put("scala", 3)
    println(map1)

    //从map中移除元素
    map1 -= "spark"
    map1.remove("hadoop")
    println(map1)
  }
}
