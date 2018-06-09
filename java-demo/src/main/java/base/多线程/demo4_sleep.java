package base.多线程;

/**
 * Created by wanglei on 2018/1/21.
 * sleep
 * <p>
 * 线程睡眠
 */
public class demo4_sleep {
    public static void main(String[] args) throws InterruptedException {
//        demo1();
        new Thread("线程-1-") {
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    //当前线程休息1秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "现在还剩余 " + i + " 秒");
                }
            }
        }.start();
        new Thread("线程-2-"){
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    //当前线程休息1秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "现在还剩余 " + i + " 秒");
                }
            }
        }.start();


    }

    private static void demo1() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    //当前线程休息1秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("现在还剩余 " + i + " 秒");
                }
            }
        }.start();
    }
}
