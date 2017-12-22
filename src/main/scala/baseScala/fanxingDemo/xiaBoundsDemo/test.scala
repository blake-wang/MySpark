package baseScala.fanxingDemo.xiaBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  * 下边界界定
  *
  * 案例：领身份证
  *
  */
object test {

  def main(args: Array[String]): Unit = {
    //child类
    val child = new Child("Jack")
    getIDCard(child)
    //father类
    val father = new Father("Tony")
    getIDCard(father)

    //teacher类
    val teacher = new Teacher("Peter")
    getIDCard(teacher)
  }

  //界定下边界
  def getIDCard[R >: Child](person: R) {
    if (person.getClass == classOf[Child]) {
      println("please tell us your parent' names")
    } else if (person.getClass == classOf[Father]) {
      println("sign your name for your child's id card")
    } else {
      println("sorry,you are not allowed to get id card")
    }
  }
}
