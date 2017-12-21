package baseScala.caseDemo.caseClassDemo

/**
  * Created by wanglei on 2017/12/21.
  * 样例类
  * case class 与模式匹配
  *
  *
  *
  */
object demo {
  def main(args: Array[String]): Unit = {
    judgeIdentify(new Teacher("wanglei", "math"))
    //如果不用new，则调用的是apply方法
    judgeIdentify(Teacher("aixu", "chainese"))

    judgeIdentify(new Student("Jack", "109"))

    judgeIdentify(Student("Peter", "201"))

    judgeIdentify(Worker("LiHui", 32))

  }

  def judgeIdentify(p: Person): Unit = {
    p match {
      case Teacher(name, subject) => println("Teacher,name is " + name + ",subject is " + subject)
      case Student(name, classroom) => println("Student,name is " + name + ",classroom is " + classroom)
      case _ => println("Illegal access,please go out of the school!")
    }
  }
}
