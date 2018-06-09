package baseScala.ioDemo

import java.io.{BufferedWriter, File, FileWriter}

/**
  * Created by bigdata on 18-1-20.
  * BufferedWrite 结合 File  写数据到文件
  *
  * BufferedWriter 这个类中，有newLine 方法，而且这个方法是跨平台的
  *
  *
  *
  * FileWriter
  * 第二个参数默认是false，在将数据写入文件前，会先将文件的内容清空
  *         设置为true，不会清空文件，将要写入的内容追加到后面
  *
  * new FileWriter()  创建时，会监测关联的文件是否存在，如果存在就直接关联，如果不存在，就创建一个再关联
  *
  */
object FileDemo {

  def main(args: Array[String]): Unit = {
    val path = "src/testData/scalaFile.txt"
    val file = new File(path)
    println(file.delete())
    if (!file.exists()) {
//      file.createNewFile()
    }

//    appendToFile(file)

    val br = new BufferedWriter(new FileWriter(file,true))
    br.newLine()
    br.write("yang guo")
    br.write(" guojing ")
    br.write(" 黄蓉 ")
    br.flush()
    br.close()



  }

  private def appendToFile(file: File) = {
    //FileWriter 第二个参数，默认是false，每次写入文件前，会先清空文件内容，再写入。true，不清空文件内容，追加写入
    val br = new BufferedWriter(new FileWriter(file, true))
    br.write("wuliao")
    br.newLine()
    br.write("黑子")
    br.flush()
    br.close()
  }
}
