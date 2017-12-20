package baseScala

/**
  * Created by wanglei on 2017/12/20.
  * return
  */
object returnDemo {
  def main(args: Array[String]): Unit = {
    def greeting(name: String) = {
      def sayHello(name: String): String = {
        return "Hello, " + name
      }
      sayHello("wanglei")
    }

  }

}
