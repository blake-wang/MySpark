package baseScala

/**
  * Created by JSJSB-0071 on 2017/7/22.
  * 方法例子
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

  //空参，返回()
  def m3 {
    println("wanglei  1")
  }

  def m4() {
    println("wanglei  2")
  }

  def m5(): Unit = {
    println("wanglei  3")
  }

  //有参，默认返回值为空
  def m6(name: String) {
    println(name)
  }

  def main(args: Array[String]) {
    val res1 = m1(f)
    println(res1)

    val res2 = m2("朋友玩")
    println(res2) //返回的Unit，打印出来就是()

    m3
    m4()
    m5()
    m6("xingxingdiandeng")
  }
}
