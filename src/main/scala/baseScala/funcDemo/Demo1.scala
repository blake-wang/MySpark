package baseScala.funcDemo

/**
  * Created by JSJSB-0071 on 2017/7/22.
  * 定义函数的方式
  */
object Demo1 {

  val map1 = Map()

  //定义函数f1
  val f1 = (x: Int) => {
    x * 10
  }
  //定义函数f2
  val f2: Int => String = {
    x => x.toString
  }

  //定义方法  -- 这个方法要传入的参数是一个函数
  def m1(f: Int => Int): Int = {
    //在方法里面调用函数
    f1(2)
  }

  def m2(f: Int => String): String = {
    f2(19)
  }

  def main(args: Array[String]) {
    val res1 = m1(f1) //返回的是int类型
    println(res1 + 2)
    val res2 = m2(f2) //返回的是String类型
    println(res2 + 2)

    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r1 = arr.map(x => x * 10)
    val r2 = arr.map(x => x + 10)
    println(r1.toBuffer)
    println(r2.toBuffer)
  }


}
