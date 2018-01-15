package baseScala.ActorDemo.HelloActorDemo

/**
  * Created by wanglei on 2017/12/27.
  */
object demo {
  def main(args: Array[String]): Unit = {
    val helloActor = new HelloActor
    //启动actor
    helloActor.start()
    //向actor发送消息
    helloActor ! "leo"
  }

}
