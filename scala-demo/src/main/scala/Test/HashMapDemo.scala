package Test

/**
  * Created by wanglei on 2017/7/18.
  */
object HashMapDemo {
  def main(args: Array[String]): Unit = {
    val scores = Map("tom" -> 85, "jerry" -> 99, "kitty" -> 90)
    val scores2 = Map(("tom", 85), ("jerry", 99), ("kitty", 60))

    println(scores("tom"))
    println(scores2("kitty"))

    //getOrElse  如果映射中有值，返回映射中的值，没有就返回默认值
    println(scores2.getOrElse("jerry", 0))
  }

}
