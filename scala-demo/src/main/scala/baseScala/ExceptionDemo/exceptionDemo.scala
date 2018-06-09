package baseScala.ExceptionDemo

import java.io.IOException

/**
  * Created by wanglei on 2017/12/16.
  * 异常 例子
  * 异常如果捕获后没有处理，就会导致程序报错并退出
  *
  * scala中的异常捕获机制其实是case模式匹配
  *
  */
object exceptionDemo {
  def main(args: Array[String]): Unit = {
    //第一种写法
    try {
      val a = 1 / 1
      println(a)
    } catch {
      case _: Exception => println("分母不能为0")
    } finally {
      println("finally里面的代码一定会执行")
    }

    //第二种写法
    try {
      throw new IllegalArgumentException
    } catch {
      //如果不指定类型，默认匹配就是第一个
      case _: Throwable => println("第二种 IOException")
      case b: IllegalArgumentException => println("IllegalArgumentException")
    }

    //第三种写法
    try {
      throw new IOException("user define exxception-1")
    } catch {
      //指定类型后，按指定的类型匹配
      //a.printStackTrace()是将异常信息打印出来
      case a: Exception => a.printStackTrace()
        println("第三种 IOException")
      case b: IllegalArgumentException => println("IllegalArgumentException")

    }

  }
}
