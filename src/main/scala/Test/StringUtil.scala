package Test

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
object StringUtil {
  def main(args: Array[String]) {

    val str = "ASDASD&8123SAD|1231&233|AAAAA|LLLLL"

    //这里切割的话要用"\\|"，不能直接| ，直接|切出来的是每一个字符
    val strArrays = str.replace("&","").split("\\|")
    println(str.replace("&",""))
    val strArrayBuffer = strArrays.toBuffer
    val strSet  =  strArrays.toSet
    val strList  =  strArrays.toList

    println(strArrayBuffer)
    println(strSet)
    println(strList)
    strArrays(0)
    strArrays.foreach(x=>{
      println(x)
    })
    strArrayBuffer.foreach(x=>{
      println(x)
    })
    strSet.foreach(x=>{
      println(x)
    })
    strList.foreach(x=>{
      println(x)
    })

}

}
