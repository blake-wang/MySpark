package baseScala.implicitDemo

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

/**
  * Created by wanglei on 2017/12/20.
  * 隐式转换
  */
object implicitDemo {


  def main(args: Array[String]): Unit = {
    val button = new JButton("Click")
    button.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent) = {
        println("Click Me!!!")
      }
    })
  }

//  implicit def getActionListener(actionProcessFunc: (ActionEvent => Unit) = new ActionListener {
//    override def actionPerformed(e: ActionEvent) {
//      actionProcessFunc(e)
//    }
//  })
}
