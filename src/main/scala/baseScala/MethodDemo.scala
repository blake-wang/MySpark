package baseScala

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object MethodDemo {
  val f: Int => Int = {
    x => x * 10
  }

  //传入的参数是函数 ， : 后面跟的是函数类型
  def m1(f: Int => Int): Int = {
    f(2)
  }

  //传入的参数是string
  def m2(name: String): Unit = {
    println(name)
  }

  def main(args: Array[String]) {
    val res1= m1(f)
    println(res1)



    val res2 = m2("朋友玩")
    println(res2) //返回的Unit，打印出来就是()
  }

}
