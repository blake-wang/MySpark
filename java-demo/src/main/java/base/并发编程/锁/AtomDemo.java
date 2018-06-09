package base.并发编程.锁;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomDemo {
    public static void main(String[] args) {
        new MTT().start();
        new MTT().start();
        new MTT().start();
        new MTT().start();
        new MTT().start();
    }
}

class Dataa {
    static int i = 0;
    //创建锁
    static Lock lock = new ReentrantLock();

    static AtomicInteger ai = new AtomicInteger(0);

    static void operate() {
        System.out.println(ai.incrementAndGet());

//        //上锁
//        lock.lock();
//
//        //下面这两行代码，如果不加锁，多个线程执行的话，这两行代码不能保证原子性
//        i++;
//        System.out.println(i);
//
//        //解锁
//        lock.unlock();
    }
}

class MTT extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Dataa.operate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
