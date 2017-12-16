package baseScala

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object TupleDemo {
  //普通元组
  val tuple = (1,"spark",2.0)

  //对偶元组   --对偶元组是可以直接添加进map中的
  val kvTuple = ("peper",59)

  def main(args: Array[String]) {
    println("---------取出元组中的元素-------------")

    println(tuple)
    //取出元组中的第2个元素   注意，元组中元素的角标是从1开始的
    val res = tuple._2
    println(res)

    println("---------把元组转换成Map-------------")
//
//    //在数组中装元组
//    val arr = Array(("中国",100),("美国",80),("日本",60))
//    println(arr.toBuffer)
//    //把对偶的集合转换成映射
//    val resMap = arr.toMap
//    println(resMap)
  }
}
