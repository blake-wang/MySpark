package baseScala.caseDemo

/**
  * Created by wanglei on 2017/12/21.\
  * 模式匹配
  * scala模式匹配语法，有一个特点在于，可以将模式匹配的默认情况，下划线，替换为一个变量名
  * 此时模式匹配语法就会将要匹配的值赋给这个变量，从而可以在后面的处理语句中使用要匹配的值
  */
object caseDemo3 {
  def main(args: Array[String]): Unit = {

    judgeGrade("lihui", "F")
  }

  def judgeGrade(name: String, grade: String): Unit = {
    grade match {
      case "A" => println(name + ",you are excellent")
      case "B" => println(name + ",you are good")
      case "C" => println(name + ",you are just so so")
      case _grade if name == "leo" => println(name + ",you are a good boy,come on,your grade is " + _grade)
      case _grade => println("you need to work harder,your grade is " + _grade)
    }
  }

}
