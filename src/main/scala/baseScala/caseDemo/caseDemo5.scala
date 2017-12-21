package baseScala.caseDemo

/**
  * Created by wanglei on 2017/12/21.
  * 对Array和List进行模式匹配
  * 对Array进行模式匹配，分别可以匹配带有指定元素的数组，带有指定个数元素的数组，以某元素打头的数组
  * 对List进行模式匹配，与Array类似，但是需要使用List特有的::操作符
  */
object caseDemo5 {
  def main(args: Array[String]): Unit = {
    val arr1 = Array("Leo", "Aixu", "Jack", "Tony")
    greeting(arr1)
    val arr2 = Array("Leo")
    greeting(arr2)
    val arr3 = Array("Leo", "Jack", "Herry")
    greeting(arr3)
    val arr4 = Array("wanglei", "aixu")
    greeting(arr4)

    println("----------------------------------------------")

    val list1 = List("Leo")
    greeting2(list1)
    val list2 = List("Jack","Peter","Herry")
    greeting2(list2)
    val list3 = List("Leo","Hulala")
    greeting2(list3)
    val list4 = List("WangLei")
    greeting2(list4)
  }

  //Array匹配
  def greeting(arr: Array[String]): Unit = {
    arr match {
      //匹配单个元素
      case Array("Leo") => println("Hi,Leo!")
      //匹配三个元素
      case Array(girl1, girl2, girl3) => println("Hi,girls,nice to meet you." + girl1 + " and " + girl2 + " and " + girl3)
      //匹配以Leo开头的数组
      case Array("Leo", _*) => println("Hi,Leo,please introduce your friends to me!")
      //匹配任意数组
      case _ => println("Hey,who are you ?")
    }
  }

  //List匹配
  def greeting2(list: List[String]): Unit = {
    list match {
      case "Leo" :: Nil => println("Hi,Leo!")
      case girl1 :: girl2 :: girl3 :: Nil => println("Hi,girls,nice to meet you." + girl1 + " and " + girl2 + " and " + girl3)
      case "Leo" :: tail => println("Hi,Leo,please introduce your friends to me")
      case _ => println("hey,who are you?")
    }
  }
}
