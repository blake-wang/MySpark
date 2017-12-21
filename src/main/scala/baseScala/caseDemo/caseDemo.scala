package baseScala.caseDemo

/**
  * Created by wanglei on 2017/12/21.
  * 模式匹配
  * Scala没有java中的switch case语法，相对应的，Scala提供了更加强大的match case语法
  * 即模式匹配，类替代switch case ，match case 也被称为模式匹配
  *
  * match case 中，主要一个case分支满足并处理了，就不会继续判断下一个case分支了
  * （与java不同，java的switch case需要用break阻止）
  */
object caseDemo {
  def main(args: Array[String]): Unit = {
    judgeGrade("B")
  }

  def judgeGrade(grade: String) {
    grade match {
      case "A" => println("Excellent")
      case "B" => println("Good")
      case "C" => println("Just so so 1")
      case "C" => println("Just so so 2")
      case _ => println("you need work harder")
    }
  }
}
