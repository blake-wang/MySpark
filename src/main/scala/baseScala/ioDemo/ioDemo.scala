package baseScala.ioDemo

/**
  * Created by wanglei on 2017/12/21.
  * IO  读写文件
  * 案例：统计多个文件中的单词个数
  *
  */
object ioDemo {
  def main(args: Array[String]): Unit = {
    //读取文件01.txt
    val lines1 = scala.io.Source.fromFile("F:\\IdeaProjects\\MySpark\\src\\01.txt").mkString
    println(lines1)
    //读取文件02.txt
    val lines2 = scala.io.Source.fromFile("F:\\IdeaProjects\\MySpark\\src\\02.txt").mkString
    println(lines2)
    //合并两个文件的内容
    val lines = List(lines1, lines2)
    println(lines)

    val l1 = lines.flatMap(_.split(" "))
    println("l1 : " + l1)
    val l2 = l1.map((_, 1))
    println("l2 : " + l2)
    val l3 = l2.map(_._2)
    println("l3 : " + l3)
    val l4 = l3.reduceLeft(_ + _)
    println(l4)

    val finish = lines.flatMap(_.split(" ")).map((_, 1)).map(_._2).reduceLeft(_ + _)
    println(finish)


  }

}
