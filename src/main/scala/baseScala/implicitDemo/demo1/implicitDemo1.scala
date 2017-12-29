package baseScala.implicitDemo.demo1


/**
  * Created by wanglei on 2017/12/20.
  * 隐式转换
  * 要实现隐式转换，只要程序可见的范围内定义隐式转换函数即可，Scala会自动使用隐式转换函数。
  * 隐式转换函数与普通函数唯一的语法区别就是，要以implicit开头，而且最好要定义函数返回类型。
  *
  * 案例：特殊售票窗口（只接收特殊人群，比如学生、老人等）
  */
object implicitDemo1 {
  var ticketNumber = 0

  def main(args: Array[String]): Unit = {
    val leo = new Student("leo")
    buySpecialTicket(leo)

    val tec = new Teacher("tec")
    buySpecialTicket(tec)

  }

  def buySpecialTicket(p: SpecialPerson) = {
    ticketNumber += 1
    "T-" + ticketNumber
  }

  //隐式转换函数
  implicit def object2SpecialPerson(obj: Object): SpecialPerson = {
    if (obj.getClass == classOf[Student]) {
      val stu = obj.asInstanceOf[Student];
      new SpecialPerson(stu.name)
    } else if (obj.getClass == classOf[Older]) {
      val older = obj.asInstanceOf[Older];
      new SpecialPerson(older.name)
    } else {
      null
    }
  }

}
