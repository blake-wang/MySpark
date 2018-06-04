package base.并发编程.同步器;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 循环屏障
 */
public class CBDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Game Start");
            }
        });

        new Player(cyclicBarrier, "A").start();
        new Player(cyclicBarrier, "B").start();
        new Player(cyclicBarrier, "C").start();
    }
}

class Player extends Thread {
    private CyclicBarrier cyclicBarrier;

    public Player(CyclicBarrier cyclicBarrier, String name) {
        setName(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println(getName() + " is waiting other players....");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
