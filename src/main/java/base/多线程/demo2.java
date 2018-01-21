package base.多线程;

/**
 * Created by wanglei on 2018/1/21.
 * 匿名子类对象开启线程的两种方式
 *
 */
public class demo2 {
    public static void main(String[] args) {
        //方式一：匿名Thread子类
        new Thread() {                  //1,new 类(){}继承这个类
            @Override
            public void run() {         //2,重写run方法
                //3,将要执行的代码，写在run方法中
            }
        }.start();                      //4,开启线程


        //方式二：匿名Runnable子类
        new Thread(new Runnable() {     //1,new 接口(){}实现这个接口
            @Override
            public void run() {         //2,重写run方法
                //3,将要执行的代码，写在run方法中
            }
        }).start();                     //4,开启线程
    }
}
