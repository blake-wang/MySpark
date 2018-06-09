package baseScala.ArrayDemo

import scala.util.Sorting

/**
  * Created by wanglei on 2017/12/16.
  * Array不能用toString方法
  */
object ArrayDemo2 {
  def main(args: Array[String]): Unit = {
    val arr = Array(12, 2, 8, 4, 1, 6, 10, 8, 9)

    //数组中最大值
    println(arr.max)

    //求和
    println(arr.sum)

    //对数组进行排序,默认是正序排序
    Sorting.quickSort(arr)
    println(arr.toBuffer)

    //把数组中的元素取出来组成一个字符串
    val arr2 = arr.mkString
    println(arr2)

    //组成字符串，用,做分隔
    val arr3 = arr.mkString(",")
    println(arr3)

    //组成字符串，以<开头，>结尾， ,为中间符
    val arr4 = arr.mkString("<", ",", ">")
    println(arr4)


  }
}
