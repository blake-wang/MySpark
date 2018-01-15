package baseScala.fanxingDemo.XieBianHeNiBian

/**
  * Created by wanglei on 2017/12/25.
  *
  * 案例：进入会场
  */
object demo {
  def main(args: Array[String]): Unit = {
    //正常 T  Card[Professional]类型不匹配
    val leo = new Card[Master]("leo")
    enterMeet(leo)
    val jack = new Card[Professional]("jack")
    //enterMeet(jack)

    //协变 +T
    val leo1 = new Card1[Master]("leo1")
    enterMeet1(leo1)
    val jack1 = new Card1[Professional]("jack")
    enterMeet1(jack1)

    //逆变
    val leo2 = new Card2[Professional]("leo2")
    enterMeet2(leo2)
    val jack2 = new Card2[Master]("jack2")
    enterMeet2(jack2)


  }

  def enterMeet(card: Card[Master]): Unit = {
    println("welcome to have this meeting!")
  }

  def enterMeet1(card: Card1[Master]): Unit = {
    println("welcome to have this meeting!")
  }

  def enterMeet2(card: Card2[Professional]): Unit = {
    println("welcome to have this meeting!")
  }
}
