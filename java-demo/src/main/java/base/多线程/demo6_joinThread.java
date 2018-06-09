package base.多线程;

/**
 * Created by wanglei on 2018/1/21.
 * 加入线程
 * join
 * 当前线程暂停，等待指定的线程执行结束后，当前线程再继续
 * join(long)
 * 可以指定线程插入执行的时间（毫秒），时间到了以后，继续交替执行
 */
public class demo6_joinThread {
    public static void main(String[] args) {
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + "~~~~~a");
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i == 2) {
                        try {
                            //当t2执行两次以后，t1加入进来，t1执行完，t2继续执行
//                            t1.join();
                            //指定t1插入执行的毫秒值
                            t1.join(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + "~~b");
                }
            }
        };
        t1.start();
        t2.start();
    }
}
