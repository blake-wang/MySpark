package baseScala

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object _Demo {
  //定义方法
  def m2(x: Int, y: Int) = {
    x + y
  }

  // _ 把方法转换成函数
  val f2 = m2 _


  //定义方法，传入参数为函数
  def m4(f: Int=> Int): Unit = {

  }


  def main(args: Array[String]) {
    println(m2(2, 3))

    println(f2)

  }
}
