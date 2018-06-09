package base.多线程;

/**
 * Created by wanglei on 2018/1/21.
 * 守护线程
 * setDaemon
 * 其他线程都执行结束了，守护线程马上就结束执行，即使守护线程的代码还没有执行完，也马上结束执行；
 * 如果其他线程没有执行完，或者执行时间多余守护线程，守护线程这时可以先执行完。
 *
 *
 */
public class demo5_DaemonThread {
    public static void main(String[] args) {
        //创建两个匿名的Thread子类对象
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println(getName() + "~~~~~~~~a");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(getName() + "~~~b");
                }
            }
        };
        //设置t2为守护线程
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
