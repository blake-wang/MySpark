package baseScala.mapDemo

/**
  * Created by wanglei on 2017/12/18.
  * 默认是不可变的Map
  * 不可变的Map，value是不可以修改的
  */
object immutMapDemo {
  def main(args: Array[String]): Unit = {
    val m1 = Map("wanglei" -> 29, "aixu" -> 26)
    println(m1("wanglei"))
    //不可变的map，不能修改value
    //    m1("wanglei")=12


    //更新不可变的map，其实是生成一个新的map
    val m2 = m1 + ("Mike" -> 42)
    println(m1)
    println(m2)

    //移除一个元素，其实也是生成一个新的map
    val m3 = m2 - ("wanglei")
    println(m2)
    println(m3)

  }

}
