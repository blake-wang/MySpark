package baseScala.ArrayDemo

/**
  * Created by JSJSB-0071 on 2017/7/22.
  * 数组
  * Array代表的含义与Java类似，也是长度不可变的数据
  * 数组初始化后，长度就固定下来了，而且元素全部根据其类型初始化
  * 可以直接使用Array()创建数据，元素类型自动推断
  * 如果元素类型不同，类型会推断为元素的公共父类型
  */
object ArrayDemo {
  //初始化一个长度为10的泛型为Int数组，其所有元素均为0
  val arr = new Array[Int](10)

  //初始化一个长度为10的泛型为Int的数组，元素的值为10
  val arr1 = Array[Int](10)

  //初始化一个长度为5的类型是any
  val arr2 = Array(10, "haha", 3.9, "丁丁", 19800)
  val arr3 = Array[Any](10, "haha", 3.9, "丁丁", 19800)

  def main(args: Array[String]) {
    //1：打印数据
    println(arr) //打印的hashcode
    println(arr1) //打印的hashcode

    println(arr.toBuffer) //转换成ArrayBuffer，因为ArrayBuffer重写了toString方法
    println(arr1.toBuffer) //转换成ArrayBuffer，因为ArrayBuffer重写了toString方法
    println(arr2.toBuffer)

    //2：遍历数组
    //给单个元素赋值
    arr(0) = 1000
    println(arr(0))

    //遍历整个数组
    //类似java增强for循环
    for (i <- arr2) {
      println(i)
    }
    //打印角标
    for (i <- 0 to arr2.length-1) {
      println(i)
      println(arr2(i))
    }
    //根据角标取出对应元素
    for (i <- 0 until arr2.length) {
      println(arr2(i))
    }

  }
}
