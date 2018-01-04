package base.object;

/**
 * Created by wanglei on 2018/1/4.
 * System类
 */
public class SystemDemo {
    public static void main(String[] args) {
        //gc()  调用finalize，执行垃圾回收
//        gc();

        //exit() 终止当前正在运行的java虚拟机。根据惯例，非0的状态码表示异常终止，0 表示正常终止
//        exit();

        //currentTimeMillis()   当前时间的毫秒值，从1970年1月1日开始到现在的毫秒值
//        currentTimeMillis();


    }

    private static void currentTimeMillis() {
        //计算程序的执行时间

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("程序执行时间为：" + (end - start));
    }

    private static void gc() {
        for (int i = 0; i < 100; i++) {
            new Demo();     //生成没有引用的对象，这种对象在jvm中就是垃圾
            System.gc();    //运行垃圾回收器，相当于调用finalize
        }
    }

    private static void exit() {
        System.exit(1); //非0状态是异常终止，退出jvm，后面的代码就不再执行
        System.out.println("中国");
    }
}

class Demo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾被清扫了！");
    }
}
