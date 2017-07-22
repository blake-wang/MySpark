package baseScala

/**
 * Created by JSJSB-0071 on 2017/7/22.
 */
object ArrayDemo {
  //初始化一个长度为10的泛型为Int数组，其所有元素均为0
  val arr = new Array[Int](10)

  //初始化一个长度为1的泛型为Int的数组，元素的值为10
  val arr1 = Array[Int](10)

  //初始化一个长度为2的没有泛型的Int的数组，元素为10,haha
  val arr2 = Array(10,"haha")

  def main(args: Array[String]) {
    println(arr)  //打印的hashcode
    println(arr1) //打印的hashcode

    println(arr.toBuffer)  //转换成ArrayBuffer，因为ArrayBuffer重写了toString方法
    println(arr1.toBuffer) //转换成ArrayBuffer，因为ArrayBuffer重写了toString方法
    println(arr2.toBuffer)
  }
}
