package baseScala.fanxingDemo.XieBianHeNiBian

/**
  * Created by wanglei on 2017/12/25.
  * 只要专家级别的名片就可以进入会场，如果大师级别的过来了，当然可以
  * [-T] 逆变
  * Master是Professional的父类。
  * Card2[Master]是Card2[Professional]的子类
  */

class Card2[-T](val name: String) {

}
