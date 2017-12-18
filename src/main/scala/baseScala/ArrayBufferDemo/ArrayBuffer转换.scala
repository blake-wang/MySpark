package baseScala.ArrayBufferDemo

/**
  * Created by wanglei on 2017/12/16.
  * Array转换，ArrayBuffer转换
  * 对Array进行转换，获取的还是Array
  * 对ArrayBuffer进行转换，获取的还是ArrayBuffer
  *
  */
object ArrayBuffer转换 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)

    //对每个元素进程乘以2，组成新的数据
    val a2 = for (i <- a) yield i * 2
    println(a2.mkString(","))

    //过滤出2的倍数，对过滤出的元素再乘以2，组成新的数组
    //共有三种写法，需要注意区别
    val a3 = a.filter(_ % 2 == 0).map(_ * 2)
    println(a3.mkString(","))

    val a4 = a.filter {
      _ % 2 == 0
    }.map(_ * 2)
    println(a4.toBuffer)

    val a5 = a.filter(i => {
      i % 2 == 0
    }).map(i => {
      i * 5
    })
    println(a5.toBuffer)
  }
}
