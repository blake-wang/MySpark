package base.多线程;

/**
 * Created by wanglei on 2018/1/20.
 * 开启线程
 *
 * 方式一：定义一个类，继承Thread，重写run方法
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();           //4、创建Thread类的子类对象
        mt.start();                             //5、start() 开启线程，调用run方法


        for (int i = 0; i < 10000; i++) {
            System.out.println("bb~~~~~");
        }
    }
}

class MyThread extends Thread {                 //1、继承Thread
//    @Override
    public void run() {                         //2、重写run方法
        for (int i = 0; i < 10000; i++) {    //3、将要执行的代码写在run方法中
            System.out.println("aa");
        }
    }
}
