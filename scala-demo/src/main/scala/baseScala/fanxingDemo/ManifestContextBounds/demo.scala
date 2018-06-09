package baseScala.fanxingDemo.ManifestContextBounds

/**
  * Created by wanglei on 2017/12/25.
  * 在scala中，如果要实例化一个泛型数组，就必须使用Manifest Context Bounds。
  * 也就是说，如果数组元素类型为T的话，需要为类或者函数定义[T:Manifest]泛型类型，这样才能实例化Array[T]这种泛型数组
  *
  * 案例：打包饭菜（一种食品打成一包）
  */
object demo {

  def main(args: Array[String]): Unit = {

    val gongbaojiding = new Meat("gongbaojiding")
    val yuxiangrousi = new Meat("yuxiangrousi")
    val shousiyangpai = new Meat("shousiyangpai")
    val res = packageFood(gongbaojiding, yuxiangrousi, shousiyangpai)
    println(res.toBuffer)

    val baicai = new Vegetable("baicai")
    val huanggua = new Vegetable("huanggua")
    val res2 = packageFood(baicai, huanggua)
    println(res2)

  }

  def packageFood[T: Manifest](food: T*) = {
    val foodPackage = new Array[T](food.length)
    for (i <- 0 until food.length) {
      foodPackage(i) = food(i)
    }
    foodPackage
  }

}
