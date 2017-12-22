package baseScala.fanxingDemo

/**
  * Created by wanglei on 2017/12/22.
  * 测试泛型类
  *
  * scala会自动推断泛型类型特性：直接给使用了泛型类型的field赋值时，scala会自动进行类型的推断
  */
object demo {
  def main(args: Array[String]): Unit = {
    //定义了Student类的泛型为Int类型
    val stu1 = new StudentTest[Int](610)
    val schoolId1 = stu1.getSchoolId(321)
    println(schoolId1)

    //定义了Student类的泛型为Int类型
    val stu2 = new StudentTest[String]("610")
    val schoolId2 = stu2.getSchoolId("321")
    println(schoolId2)

    //自动推断类型
    val stu3 = new StudentTest(100)
    val schoolId3 = stu3.getSchoolId(200)
    println(schoolId3)

  }
}
