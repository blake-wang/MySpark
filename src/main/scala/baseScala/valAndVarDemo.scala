package baseScala

/**
  * Created by JSJSB-0071 on 2017/7/22.
  */
object valAndVarDemo {
  val a = 1
  var b = 1;

  val c = List(1, 2, 3, 4)
  val d = List(1, 2, 3, 4)

  def main(args: Array[String]) {
    println("----------Int 改变值------------")
    //a =2;    //a的值和数据类型都是不可变

    println(b)
    b = 3; //b的值是可以边的
    println(b)
    //b = "haha" //b的值可以改变，但是数据类型不能改变

    println("----------List 改变值------------")
    //    c.+=(5)
    //    d.+=(5)
  }

}
