package baseScala.caseDemo

/**
  * Created by wanglei on 2017/12/21.
  * 模式匹配
  * if守卫，可以多做一次判断
  */
object caseDemo2 {
  def main(args: Array[String]): Unit = {
    judgeGrade("jack", "D")
  }

  def judgeGrade(name: String, grade: String): Unit = {
    grade match {
      case "A" => println(name + ",Excellent")
      case "B" => println(name + ",Good")
      case "C" => println(name + ",Just so so")
      //可以用if再做一次判断
      case _ if name == "leo" => println(name + ",you are a good boy,come on")
      case _ if name == "jack" => println(name + ",are you jack ma?")
      case _ => println("you need to work harder")
    }
  }
}
