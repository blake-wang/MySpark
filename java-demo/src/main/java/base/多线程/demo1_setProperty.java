package base.多线程;

/**
 * Created by wanglei on 2018/1/22.
 * 设置线程的优先级
 * <p>
 * setProperty
 */
public class demo1_setProperty {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + "~~~a");
                }

            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + "~~~bbbbb");
                }
            }
        };

//        t1.setPriority(10);
//        t2.setPriority(1);

        t1.setPriority(Thread.MAX_PRIORITY);//设置最大优先级
        t2.setPriority(Thread.MIN_PRIORITY);//设置最小优先级


        t1.start();
        t2.start();

    }
}
