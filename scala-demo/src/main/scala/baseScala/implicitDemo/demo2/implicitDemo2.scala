package baseScala.implicitDemo.demo2

/**
  * Created by wanglei on 2017/12/25.
  * 隐式转换非常强大的一个功能，就是可以在不知不觉中加强现有类型的功能。
  * 也就是说，可以为某个类定义一个加强版的类，并定义互相之间的隐式转换，从而让源类在使用加强版的方法时，
  * 由scala自动进行隐式转换为加强类，然后再调用该方法
  *
  * 案例：超人变身
  *
  */
object implicitDemo2 {

  def main(args: Array[String]): Unit = {
    val leo = new Man("leo")
    leo.emitLaser
  }

  //加强版的隐式转换，对原类进行加强
  implicit def man2superman(man: Man): Superman = new Superman(man.name)

}
