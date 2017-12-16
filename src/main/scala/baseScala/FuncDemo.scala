package baseScala

/**
  * Created by JSJSB-0071 on 2017/7/22.
  * 函数例子
  */
object FuncDemo {
  //函数的两种写法

  //1   这种方式规定了传入的参数，返回什么由函数体决定  常用
  val func1 = (a: Int, b: Double) => {
    (b, a)
    (b, a, a + 100) //默认返回的是最后一行
  }

  //2   这种方式可以看到传入什么参数，返回什么   不常用
  val func2: (Int, Double) => (Double, Int) = {
    (a, b) => (b, a)
  }

  def main(args: Array[String]) {
    println(func1(19, 20.8))
    println(func2(33, 92.7))
  }

}
