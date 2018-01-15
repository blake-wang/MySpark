package demo.secondSortDemo

/**
  * Created by wanglei on 2018/1/1.
  * 自定义一个排序的类
  */
class SecondSort(val first: Int, val second: Int) extends Ordered[SecondSort] with Serializable {
  override def compare(that: SecondSort): Int = {
    if (this.first - that.first != 0) {
      this.first - that.first
    } else {
      this.second - that.second
    }
  }
}