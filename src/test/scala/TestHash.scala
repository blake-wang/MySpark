/**
  * Created by wanglei on 2017/6/2.
  */
object TestHash {
  def main(args: Array[String]): Unit = {
    val mod = "java.itcast.cn"
    val num = 3
    val index = mod.hashCode % num

  }

}
