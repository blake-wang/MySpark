package base.多线程;

/**
 * Created by wanglei on 2018/1/21.
 * Thread API
 * <p>
 * Thread-0   子线程的编号从 0 开始
 * <p>
 * getName  获取线程名称
 * setName  设置线程名称
 * Thread.currentThread  获取当前线程对象
 */
public class demo3_currentThread {
    public static void main(String[] args) {

        //获取当前线程的对象
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        //获取当前线程的名字 主线程的默认的名字是main
        String name = thread.getName();
        System.out.println(name + "~~~main");
        thread.setName("我是主线程！");
        System.out.println(thread.getName());


        new Thread() {
            @Override
            public void run() {
                //获取当前线程的名称
                System.out.println(getName() + "~~~a");
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //在Runnable子类中获取当前线程的对象
                System.out.println(Thread.currentThread().getName() + "~~~b");
            }
        },"凤姐专用线程 ").start();
    }
}
