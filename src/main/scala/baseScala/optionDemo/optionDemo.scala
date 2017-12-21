package baseScala.optionDemo

/**
  * Created by wanglei on 2017/12/21.
  * Option 与模式匹配
  *
  * scala有一种特殊的类型，叫Option，
  *
  * Option有两种值，一种是Some，表示有值，一种是None，表示没有值
  *
  * Option的用法必须掌握，因为spark源码中大量的使用了Option，比如Some(a),None这种语法，因此必须看得懂Option模式匹配，才能读懂spark源码
  */
object optionDemo {
  val grades = Map("Leo" -> "A", "Jack" -> "B", "Jen" -> "C")

  def main(args: Array[String]): Unit = {

    getGrade("Leo")

    getGrade("WangLei")

  }

  def getGrade(name: String): Unit = {
    val grade = grades.get(name)
    grade match {
      case Some(grade) => println("your grade is " + grade)
      case None => println("Sorry,your grade information is not in the system!")
    }
  }

}
