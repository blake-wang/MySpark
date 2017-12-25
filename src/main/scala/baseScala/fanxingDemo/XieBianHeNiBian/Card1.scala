package baseScala.fanxingDemo.XieBianHeNiBian

/**
  * Created by wanglei on 2017/12/25.
  * 大师以及大师级别以下的名片都可以进入会场
  * [+T] 是 协变
  * Master是Professional的父类
  * Card1[Master]也是Card1[Professional]的父类
  */

class Card1[+T](val name: String) {

}
