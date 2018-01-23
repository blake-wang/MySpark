package base.多线程;

/**
 * Created by wanglei on 2018/1/22.
 * <p>
 * 礼让线程
 * <p>
 * yield  让出cpu
 */
public class demo7_yield {
    public static void main(String[] args) {
        new MyThread2().start();
        new MyThread2().start();

    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 10 == 0) {
                Thread.yield();//让出CPU
            }
            System.out.println(getName() + "~~~a~~~"+ i);
        }

    }
}
