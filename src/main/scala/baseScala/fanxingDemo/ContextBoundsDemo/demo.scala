package baseScala.fanxingDemo.ContextBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  * Context Bounds是一种特殊的Bounts，它会根据泛型类型的声明，
  * 比如"T:类型"要求必须存在一个类型为"类型[T]"的隐式值。
  * 其实个人认为，Context Bounds之所以叫Context，是因为它基于的是一种全局的上下文，
  * 需要使用到上下文中的隐式值以及注入
  */
object demo {
  def main(args: Array[String]): Unit = {
    val sum = new Calculator(1,2).max
    println(sum)

  }
}
