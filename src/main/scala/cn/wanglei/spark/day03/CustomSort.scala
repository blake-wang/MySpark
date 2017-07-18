package cn.wanglei.spark.day03

import org.apache.spark.{SparkConf, SparkContext}

//object OrderContext {
//
//  implicit object GirlOrdering extends Ordering[Girl] {
//    override def compare(x: Girl, y: Girl): Int = {
//      if (x.faceValue > y.faceValue) 1
//      else if (x.faceValue == y.faceValue) {
//        if (x.age > y.age) -1 else 1
//      } else -1
//    }
//  }
//
//}
object OrderContext {

  implicit val girlOrdering = new Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = {
      if (x.faceValue > y.faceValue) 1
      else if (x.faceValue == y.faceValue) {
        if (x.age > y.age) -1 else 1
      } else -1
    }
  }

}

/**
  * Created by wanglei on 2017/6/2.
  */
object CustomSort {
  def main(args: Array[String]): Unit = {
    val config = new SparkConf().setAppName("CustomSort").setMaster("local[2]")
    val sc = new SparkContext(config)
    val rdd1 = sc.parallelize(List(("章子怡", 90, 36, 1), ("张娜拉", 80, 32, 2), ("韩红", 60, 40, 1), ("泰勒斯威夫特", 90, 26, 1), ("佟丽娅", 95, 34, 1)), 3)
    //第一种方式
    //传入自己定义的比较规则   rdd里面不需要reverse，false是降序
    //    val rdd2 = rdd1.sortBy(x => Girl(x._2, x._3), false)
    //    println(rdd2.collect().toBuffer)

    //第二种方式 --  用隐式转换
    import OrderContext._
    val rdd2 = rdd1.sortBy(x => Girl(x._2, x._3), false)
    println(rdd2.collect().toBuffer)
    sc.stop()
  }
}

//第一种方式排序   继承Ordered with Serializable
//case class Girl(val faceValue: Int, val age: Int) extends Ordered[Girl] with Serializable {
//  override def compare(that: Girl): Int = {
//    if (this.faceValue == that.faceValue) {
//      //          如果颜值相等，年龄小的排在前面
//      that.age - this.age
//    } else {
//      //颜值高的排在前面
//      this.faceValue - that.faceValue
//    }
//    ArrayBuffer((佟丽娅,95,34,1), (泰勒斯威夫特,90,26,1), (章子怡,90,36,1), (张娜拉,80,32,2), (韩红,60,40,1))

//    if (this.faceValue == that.faceValue) {
//      //如果颜值相等，年龄大的排在前面
//      this.age - that.age
//    } else {
//      //颜值高的排在前面
//      this.faceValue - that.faceValue
//    }
//    ArrayBuffer((佟丽娅,95,34,1), (章子怡,90,36,1), (泰勒斯威夫特,90,26,1), (张娜拉,80,32,2), (韩红,60,40,1))

//    if (this.faceValue == that.faceValue) {
//      //如果颜值相等，年龄小的排在前面
//      that.age - this.age
//    } else {
//      //颜值低的排在前面
//      that.faceValue - this.faceValue
//    }
//    ArrayBuffer((韩红,60,40,1), (张娜拉,80,32,2), (泰勒斯威夫特,90,26,1), (章子怡,90,36,1), (佟丽娅,95,34,1))
//  }
//}

//第二种方式 -- 通过隐式转换方式进行排序
case class Girl(faceValue: Int, age: Int) extends Serializable
