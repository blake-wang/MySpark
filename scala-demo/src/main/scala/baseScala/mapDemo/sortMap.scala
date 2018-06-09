package baseScala.mapDemo

/**
  * Created by wanglei on 2017/12/18.
  * map的排序
  * SortedMap可以自动对Map的key排序
  */
object sortMap {
  def main(args: Array[String]): Unit = {

    val m1 = Map("wanglei" -> 12, "aixu" -> 26, "zhangxin" -> 44)
    println(m1)
    //SortedMap可以自动对Map的key进行排序
    val m2 = scala.collection.immutable.SortedMap[String, Int]("wanglei" -> 12, "aixu" -> 26, "zhangxin" -> 44)
    println(m2)

  }
}
