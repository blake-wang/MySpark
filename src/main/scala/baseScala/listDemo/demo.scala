package baseScala.listDemo

/**
  * Created by wanglei on 2017/12/21.
  * 集合的高阶函数
  */
object demo {
  def main(args: Array[String]): Unit = {
    //map
    val list = List("wanglei", "aixu", "xingxing")
    val list2 = list.map("name is " + _)
    println(list)
    println(list2)

    //flatMap
    val list3 = List("Hello World", "You Me")
    val list4 = list3.flatMap(_.split(" "))
    println(list3)
    println(list4)

    //foreach  三种写法
    val list5 = List("wanglei", "aixu", "xingxing", "lihui", "kequan")
    //1
    list5.foreach(println(_))
    //2
    list5.foreach(yy => println(yy))
    //3
    list5.foreach(pp => {
      println(pp)
    })

    //zip
    val list6 = List("wanglei", "aixu", "xingxing", "lihui", "kequan")
    val list7 = List(1, 2, 3, 4, 5)
    val list8 = list6.zip(list7)
    println(list8)

  }
}
