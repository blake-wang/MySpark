package base.并发编程.同步器;

import java.util.concurrent.Semaphore;

/**
 * Semaphore  信号量
 */
public class SeDemo {
    public static void main(String[] args) {
        //创建信号量，拥有多少个许可证
        //有多少个许可证，就允许多少个并发线程进入这个区域
        Semaphore semaphore = new Semaphore(2);

        Person p1 = new Person(semaphore, "A");
        p1.start();
        Person p2 = new Person(semaphore, "B");
        p2.start();
        Person p3 = new Person(semaphore, "C");
        p3.start();

    }
}

class Person extends Thread {
    private Semaphore semaphore;

    public Person(Semaphore semaphore, String name) {
        //设置线程名称
        setName(name);
        this.semaphore = semaphore;
    }

    public void run() {
        System.out.println(getName() + " is waiting ...");
        try {
            //获取许可证
            semaphore.acquire();
            System.out.println(getName() + " is servicing...");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " is done!");
        //释放许可证
        semaphore.release();
    }
}
