package base.多线程;

/**
 * Created by wanglei on 2018/1/20.
 * 证明jvm是多线程的
 *
 * 一个是主线程，一个是垃圾回收线程
 */
public class demo1 {
    public static void main(String[] args) {
        //两个for循环在交替打印，证明jvm至少启动了两个线程

        for (int i = 0; i < 10000000; i++) {
            new Demo();
        }

        for (int i = 0; i < 100000; i++) {
            System.out.println("主线程在执行~~~~~~~~。");
        }
    }
}
class Demo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾被清理了");
    }
}
