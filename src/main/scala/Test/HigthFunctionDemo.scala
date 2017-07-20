package Test

/**
  * Created by wanglei on 2017/7/18.
  */
object HigthFunctionDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)

    val fun1 = (x: Int) => x * 2

    //生成的是一个新的数组，不改变原来的数组
    val arr2 = arr.map(fun1)
    println(arr2.toBuffer)
    val arr3 = arr.map(x => x * 4)
    println(arr3.toBuffer)

    val arr4 = arr.map(_ * 2)
    println(arr4.toBuffer)
    //增强for循环
    for(i<-arr4){
      println(i)
    }

    //普通for循环  ，可以拿到index
    for( i<- 0 until(arr4.length)){
      println(arr4(i))
    }


  }

}
