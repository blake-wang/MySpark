package base.多线程;

/**
 * Created by wanglei on 2018/1/22.
 * 同步方法
 * 同步方法，只需要在方法上加synchronized关键字就行
 *
 * 静态同步方法和非静态同步方法
 */
public class demo9_synchronized2 {
    public static void main(String[] args) {
        final Printer2 p = new Printer2();

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

class Printer2 {
    //非静态的同步方法，锁对象是this
    public synchronized void print1() {         //同步方法，给方法上加synchronized
        System.out.print("世");
        System.out.print("界");
        System.out.print("那");
        System.out.print("么");
        System.out.print("大");
        System.out.print("\r\n");
    }

    public synchronized void print2() {
        System.out.print("我");
        System.out.print("想");
        System.out.print("去");
        System.out.print("看");
        System.out.print("看");
        System.out.print("\r\n");
    }


    //静态的同步方法，锁对象是该类的字节码文件
    public static synchronized void print3() {
        System.out.print("世");
        System.out.print("界");
        System.out.print("那");
        System.out.print("么");
        System.out.print("大");
        System.out.print("\r\n");
    }

    public static synchronized void print4() {
        System.out.print("我");
        System.out.print("想");
        System.out.print("去");
        System.out.print("看");
        System.out.print("看");
        System.out.print("\r\n");
    }

}
