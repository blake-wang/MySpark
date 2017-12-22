package baseScala.fanxingDemo.shangBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  * 上边界界定
  * [T <: Person]
  */
object test {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("Peter")
    p1.sayHello
    p1.makeFriend(new Person("Jack"))

    //Student是Peter的子类
    p1.makeFriend(new Student("WangLei"))

    //Worker不是Peter的子类，所以不能传入
    //    p1.makeFriend(new Worker("AiXu"))

    val par = new Party[Person](new Student("KeQuan"), new Student("LiHui"))
    par.play


  }

}
