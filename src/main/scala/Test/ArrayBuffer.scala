package Test

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wanglei on 2017/7/18.
  */
object ArrayBuffer {
  def main(args: Array[String]): Unit = {
    var params = new ArrayBuffer[Array[Any]]()
    params.+=(Array[Any](12, "嘿嘿", "2017-07-16"))
    for (i <- 1 to 10) {
      params.+=(Array[Any]("13:" + i, "艾旭：" + i))
    }


    for (i <- params) {
      println(i.toBuffer)
      for (j <- i) {
        println(j)
      }
    }
  }

}
