package baseScala.fanxingDemo.ContextBoundsDemo

/**
  * Created by wanglei on 2017/12/22.
  */
class Calculator[T: Ordering](val number1: T, val number2: T) {
  def max(implicit order: Ordering[T]) = if (order.compare(number1, number2) > 0) number1 else number2
}
