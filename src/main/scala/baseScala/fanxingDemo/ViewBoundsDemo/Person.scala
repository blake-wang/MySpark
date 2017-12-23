package baseScala.fanxingDemo.ViewBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  */
class Person(val name: String) {
  def sayHello = println("Hello,I'm " + name)

  def makeFriends(p: Person): Unit = {
    sayHello
    p.sayHello
  }

}
