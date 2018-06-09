package baseScala.caseDemo

import java.io.{FileNotFoundException, IOException}


/**
  * Created by wanglei on 2017/12/21.
  * 对类型进行模式匹配
  *
  * 代码：
  * case 变量：类型 => 代码
  *
  * 可以直接匹配类型
  */
object caseDemo4 {

  def main(args: Array[String]): Unit = {
    try {
      val a = 1 / 0
    } catch {
      case e: Exception => e.printStackTrace()
        processException(e)
    }

    processException(new IndexOutOfBoundsException)
    processException(new FileNotFoundException)

  }

  def processException(e: Exception): Unit = {
    e match {
      case e1: IllegalArgumentException => println("you have illegal arguments! exceptionDemo1 is:" + e1)
      case e2: FileNotFoundException => println("cannot find the file you need read or write!,exceptionDemo1 is:" + e2)
      case e3: IOException => println("you got an error while you were doing IO operation! exceptionDemo1 is: " + e3)
      case e4: ArithmeticException => println("exceptionDemo1 is: " + e4)
      case _: Exception => println("cannot know which exceptionDemo1 you have!")
    }
  }
}
