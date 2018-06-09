package baseScala.fanxingDemo.shangBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  * 上边界界定
  */
class Party[T <: Person](p1: T, p2: T) {
  def play = p1.makeFriend(p2)
}
