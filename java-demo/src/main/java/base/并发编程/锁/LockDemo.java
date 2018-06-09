package base.并发编程.锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁 Lock
 */
public class LockDemo {
    public static void main(String[] args) {
        new MT().start();
        new MT().start();
        new MT().start();
        new MT().start();
        new MT().start();

    }
}

class Data {
    static int i = 0;
    //创建锁
    static Lock lock = new ReentrantLock();

    static void operate() {
        //上锁
        lock.lock();

        //下面这两行代码，如果不加锁，多个线程执行的话，这两行代码不能保证原子性
        i++;
        System.out.println(i);

        //解锁
        lock.unlock();
    }
}

class MT extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Data.operate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
