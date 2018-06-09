package base.多线程.死锁;

/**
 * Created by wanglei on 2018/1/23.
 * 死锁
 *
 * 为了避免死锁问题的出现，一定要避免同步代码块的嵌套
 */
public class Demo1 {

    public static void main(String[] args) {
        final String s1 = "筷子-左";
        final String s2 = "筷子-右";
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println(getName() + " 拿到 " + s1 + ",等待 " + s2);
                        synchronized (s2) {
                            System.out.println(getName() + " 拿到 " + s2 + ",开吃");
                        }

                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName() + " 拿到 " + s2 + ",等待 " + s1);
                        synchronized (s1) {
                            System.out.println(getName() + " 拿到 " + s1 + ",开吃");
                        }

                    }
                }
            }
        }.start();


    }
}
