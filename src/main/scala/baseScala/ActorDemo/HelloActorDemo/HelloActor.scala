package baseScala.ActorDemo.HelloActorDemo

import scala.actors.Actor

/**
  * Created by wanglei on 2017/12/27.
  * Scala提供了Actor trait来让我们更方便的进行actor多线程编程，就Actor trait就类似于Java中的Thread和Runnable一样，
  * 是基础多线程基类和接口。
  * 我们只要重写Actor trait的act()方法，即可实现自己的线程执行体，与java中重写run方法类似。
  * 此外，使用start()方法启动actor，使用！符号，向actor发送消息，actor内部使用receive和模式匹配接收消息
  *
  *
  * 案例：Actor Hello World
  */
class HelloActor extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case name: String => println("Hello, " + name)
      }
    }
  }
}
