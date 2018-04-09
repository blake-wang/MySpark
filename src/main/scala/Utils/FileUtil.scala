package Utils

import java.io.{BufferedWriter, File, FileWriter}

import org.apache.spark.sql.DataFrame

/**
  * Created by kequan on 4/26/17.
  */
object FileUtil {
  def main(args: Array[String]): Unit = {

    val str = "wo ai ni xiao xu xu "
    for (i <- 1 to 1000000) {
      apppendTofile("f:\\Data\\count.txt", str + i)
    }
  }


  /**
    * del
    *
    * @param fileName
    */
  def delfile(fileName: String) = {
    //将数据存入文件
    val file = new File(fileName)
    if (file.exists()) {
      file.delete()
    }

  }

  /**
    * 覆盖
    *
    * @param fileName
    * @param s
    */
  def overWriteTofile(fileName: String, s: String) = {
    //将数据存入文件
    val file = new File(fileName)
    if (!file.exists()) {
      file.createNewFile()
    }
    val writer = new BufferedWriter(new FileWriter(file, true))
    writer.write(s, 0, s.length)
    writer.flush()
    writer.close()
  }


  /**
    * 追加到文件
    *
    * @param fileName
    * @param s
    */
  def apppendTofile(fileName: String, s: String) = {
    //将数据存入文件
    val file = new File(fileName)
    if (!file.exists()) {
      file.createNewFile()
    }
    val writer = new BufferedWriter(new FileWriter(file, true))
    writer.append(s)
    writer.newLine()
    writer.flush()
    writer.close()
  }

  /**
    * 存储DataFrame时用
    *
    * @param df
    * @param fileName
    */
  def apppendDfTofile(df: DataFrame, fileName: String) = {
    df.foreachPartition(iter => {
      iter.foreach(t => {
        apppendTofile(fileName, t.toString());
      })
    })
  }

}
