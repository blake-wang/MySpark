package base.多线程;

/**
 * Created by wanglei on 2018/1/22.
 * 同步代码块
 * synchronized
 * 锁机制，锁可以是任意的
 * 锁对象不能用匿名对象，因为匿名对象不是同一个对象
 */
public class demo8_synchronized {
    public static void main(String[] args) {
        final Printer p = new Printer();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    p.print1();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    p.print2();
                }
            }
        }.start();

    }
}

class Printer {
    public void print1() {
        synchronized (this){
            System.out.print("世");
            System.out.print("界");
            System.out.print("那");
            System.out.print("么");
            System.out.print("大");
            System.out.print("\r\n");
        }
    }

    public void print2() {
        synchronized (this){
            System.out.print("我");
            System.out.print("想");
            System.out.print("去");
            System.out.print("看");
            System.out.print("看");
            System.out.print("\r\n");
        }
    }
}
