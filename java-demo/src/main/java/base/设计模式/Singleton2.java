package base.设计模式;

/**
 * Created by wanglei on 2018/1/23.
 * 单例模式 ： 懒汉式
 * 单例的延迟加载模式
 */
public class Singleton2 {
    //1、私有化构造方法
    private Singleton2() {
    }

    //2、声明一个本类引用
    private static Singleton2 s = null;

    //3、对外提供公共的访问方法
    public static Singleton2 getSingleton2() {
        if (s == null) {
            synchronized (Singleton2.class) {
                if (s == null) {
                    s = new Singleton2();
                }
            }
        }
        return s;
    }
}
