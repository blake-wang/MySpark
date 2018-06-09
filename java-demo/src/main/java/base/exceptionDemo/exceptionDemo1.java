package base.exceptionDemo;

/**
 * Created by wanglei on 2018/1/15.
 * 异常类
 * finally 的执行顺序
 * <p>
 * 如何使用异常处理：
 * 原则：如果该功能内部可以将问题处理，用try，如果处理不了，交由调用者处理，这是用throws
 * 区别：
 * 后续程序需要继续运行就try
 * 后续程序不需要继续运行就throws
 */
public class exceptionDemo1 {
    public static void main(String[] args) {
        int method = new Demo().method();
        System.out.println(method);

    }
}

class Demo {
    public int method() {
        int x = 10;
        try {
            x = 20;
            System.out.println(x / 0);
            return x;
        } catch (Exception e) {
            x = 30;
            return x;
        } finally {
            x = 40;
            //千万不要在finally里面写返回语句，因为finally的作用是为了释放资源，是肯定会执行的
            //如果在这里面写返回语句，那么try和catch的结果都会被改变

        }
    }
}
