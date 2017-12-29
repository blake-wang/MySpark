package baseScala.ActorDemo.caseClassDemo

import scala.actors.Actor

/**
  * Created by wanglei on 2017/12/27.
  * scala的Actor模型与Java的多线程模型之间，很大的一个区别就是，Scala Actor天然支持线程之间的精准通信，
  * 即一个actor可以给其他actor发送消息，这个功能是非常强大的。
  * 要给一个actor发送消息，需要使用"actor!消息"的语法。在scala中，通常建议使用样例类，即case class来作为消息进行发送。
  * 然后在actor接收消息之后，可以使用scala强大的模式匹配功能来进行不同消息的处理
  */
class UserManagerActor extends Actor {
  override def act() {
    while (true) {
      receive {
        case Login(username, password) => println("login,username is " + username + ",password is " + password)
        case Register(username, password) => println("register,username is " + username + ",password is " + password)
      }
    }

  }
}

case class Login(username: String, password: String)

case class Register(username: String, password: String)
