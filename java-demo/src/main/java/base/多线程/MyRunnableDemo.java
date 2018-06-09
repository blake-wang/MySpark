package base.多线程;

/**
 * Created by wanglei on 2018/1/20.
 * 开启一个线程
 * <p>
 * 方式二 ： 定义一个类，实现Runnable接口，重写run方法
 */
public class MyRunnableDemo {
    public static void main(String[] args) {

        MyRunnable mr = new MyRunnable();       //4、创建Runnable的子类对象
        Thread t = new Thread(mr);              //5、将其当作参数传递给Thread的构造函数
        t.start();                              //6、开启线程


        for (int i = 0; i < 10000; i++) {
            System.out.println("我是主线程~~~~~~");
        }

    }
}

class MyRunnable implements Runnable {          //1、定义一个类，实现Runnable接口

    @Override
    public void run() {                         //2、重写run方法
        for (int i = 0; i < 10000; i++) {

            System.out.println("我是runnable");   //3、将要执行的代码写在run方法中
        }
    }
}
