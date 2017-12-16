package baseScala

import scala.io.Source._

/**
  * Created by wanglei on 2017/12/16.
  * lazy 特性
  * 如果将一个变量声明为lazy，则只有在第一次使用该变量时
  * 变量对应的表达式才会发生计算
  * 这种特性对于特别耗时的计算操作特别有用，比如打开文件进行IO，进行网络IO等
  *
  */
object lazyDemo {
  def main(args: Array[String]): Unit = {
    lazy val lines = fromFile("F:\\haha.txt").mkString
    println(lines)
  }
}
