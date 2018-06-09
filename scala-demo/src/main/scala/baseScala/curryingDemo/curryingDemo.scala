package baseScala.curryingDemo

/**
  * Created by wanglei on 2017/12/20.
  * currying函数
  * 柯里化
  */
object curryingDemo {
  def main(args: Array[String]): Unit = {
    println(sum(1, 1))
    println(sum2(1)(1))
    println(sum3(1)(1))

  }

  def sum(a: Int, b: Int) = a + b

  def sum2(a: Int) = (b: Int) => a + b

  def sum3(a: Int)(b: Int) = a + b

}
