package base.多线程.并发;

/**
 * Created by wanglei on 2018/1/23.
 * 多线程并发，容易引起线程安全问题
 *
 * <p>
 * 案例：铁路售票，一共100张，通过四个窗口卖完。
 *
 * 继承Thread
 */
public class Demo1_Ticket {
    public static void main(String[] args) {
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();

    }
}

class Ticket extends Thread {
    //成员变量，每个对象有拥有一个自己的成员变量，如果开四个线程卖票，会卖出 100*4 张票
//    private int ticketNum = 100;

    //静态变量，所有对象共享同一个静态变量
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            //用同步代码块，可以解决多个线程同时处理一个共享数据的数据安全问题
            synchronized (Demo1_Ticket.class) {
                if (ticketNum == 0) {
                    System.out.println(getName()+" 票卖完了！");
                    break;
                }

                try {
                    Thread.sleep(10);   //线程1睡，线程2睡，线程3睡，线程4睡
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(getName() + " 正在出售第 " + ticketNum-- + " 张票！");

            }
        }
    }
}
