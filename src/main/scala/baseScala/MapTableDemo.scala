package baseScala

import java.util.HashMap

/**
 * Created by JSJSB-0071 on 2017/7/22.
 *
 * 映射
 */
object MapTableDemo {
  //
  //第一种创建Map的方式，用箭头
  val map1 = Map("tom" -> 85, "jerry" -> 99, "blake" -> 60)
  //第二种创建Map的方式，用元组
  val map2 = Map(("tom", 85), ("jerry", 99), ("blake", 60))
  //第三种创建Map的方式，使用java中的Map
  val jMap1 = new HashMap()
  val jMap2 = new HashMap[String,Int]()




  //注意，在scala中，有两种Map，一个是immutable包下的Map，该Map中的内容不可变
  //                        一个是mutable包下的Map，该Map中的内容可变
  //通常 我们在创建一个集合是会用val这个关键字，


  //MAP内容不可以改变
  val m1 = scala.collection.mutable.Map("a" -> 1, "b" -> 2)
  //MAP内容可以改变
  var m2 = scala.collection.immutable.Map("a" -> 1, "b" -> 2)


  //对偶元组   --对偶元组是可以直接添加进map中的
  val kvTuple = ("peper",59)


  def main(args: Array[String]) {
    println(map1)
    println(map2)
    //获取和修改映射中的值

    //1、获取映射中的值
    val v1 = map1("tom")
    println(v1)
    val v11 = map1.getOrElse("tomm", 100) //getOrElse方法，取到就返回，没有就返回100
    println(v11)
    //2、改变映射中的值
    //map1("tom") = 123456             //默认创建的是不可改变的map

    println("--------------------------")

    println(m1)
    println(m1("a")) //通过键a取出对应的值
    println(m1("a"))
    m1.get("a") //取出键a对应的值，并把值放进some里面，Some(1)
    println(m1.get("a"))
    m1("a") = 66
    println(m1) //键a对应的值已经改变
    m1("c") = 1000
    println(m1) //给map添加一个c

    println("--------------------------")
    println(m2)
    println(m2("a")) //通过键a取出对应的值

//    m2("a") = 66
    m2 += kvTuple    //把元组添加进m2
    println(m2)      //m2的值不可以更改

  }


}
