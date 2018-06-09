package base.多线程.并发;

/**
 * Created by wanglei on 2018/1/23.
 * <p>
 * 案例：铁路售票，一共100张，通过四个窗口卖完。
 * <p>
 * 实现runnable接口
 */
public class Demo2_Ticket {
    public static void main(String[] args) {
        Ticket2 t = new Ticket2();

        //开启四个线程，但是runnable对象只有一个
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();


//        Thread t1 = new Thread(t);
//        t1.start();             //多次启动同一个线程，是非法的，报异常
//        t1.start();
//        t1.start();
//        t1.start();


    }
}

class Ticket2 implements Runnable {
    //因为只new了一个对象，所以这个变量只有一份
    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            //用同步代码块，可以解决多个线程同时处理一个共享数据的数据安全问题
            synchronized (Demo1_Ticket.class) {
                if (ticketNum == 0) {
                    System.out.println(Thread.currentThread().getName() + " 票卖完了！");
                    break;
                }

                try {
                    Thread.sleep(10);   //线程1睡，线程2睡，线程3睡，线程4睡
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 正在出售第 " + ticketNum-- + " 张票！");

            }
        }

    }
}

