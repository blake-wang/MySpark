package baseSpark.rowDemo

import org.apache.spark.sql.{Row, RowFactory}

/**
  * Created by bigdata on 18-1-9.
  * 创建Row
  *
  */
object createRowDemo {
  def main(args: Array[String]): Unit = {
    val row = RowFactory.create("wanglei",Integer.valueOf("26"));
    println(row)

    val row2 = Row("wanglei",26)
    println(row2)
  }

}
