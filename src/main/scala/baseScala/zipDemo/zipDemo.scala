package baseScala.zipDemo

/**
  * Created by wanglei on 2017/12/18.
  * zip 拉链操作
  * 将两个数据组装在一起
  */
object zipDemo {
  def main(args: Array[String]): Unit = {
    val names = Array("leo", "jack", "mike")
    val ages = Array(30, 24, 26)
    val nameAges = names.zip(ages)
    println(nameAges.toBuffer)

    //遍历
    for ((name, age) <- nameAges) {
      println(name + " : " + age)
    }
  }

}
