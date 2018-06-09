package baseScala.fanxingDemo.shangBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  */
class Person(val name: String) {
  def sayHello = println("Hello,I'am " + name)

  def makeFriend(p: Person): Unit = {
    sayHello
    p.sayHello
  }
}
