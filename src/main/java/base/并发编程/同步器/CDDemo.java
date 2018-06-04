package base.并发编程.同步器;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch  计数栓
 */
public class CDDemo {
    public static void main(String[] args) {
        //创建计数栓
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //创建三个线程，这些线程会依赖于计数栓的计数
        Racer racer1 = new Racer(countDownLatch, "A");
        racer1.start();
        Racer racer2 = new Racer(countDownLatch, "B");
        racer2.start();
        Racer racer3 = new Racer(countDownLatch, "C");
        racer3.start();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3-i);
            //当计数栓计数为0时，所有线程并发执行
            countDownLatch.countDown();

            if (i == 2) {
                System.out.println("Start");
            }
        }
    }
}

class Racer extends Thread {
    private CountDownLatch countDownLatch;

    public Racer(CountDownLatch countDownLatch, String name) {
        setName(name);
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            countDownLatch.await();
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " : " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
