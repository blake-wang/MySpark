package base.设计模式;

/**
 * Created by wanglei on 2018/1/23.
 * 单例设计模式 ： 饿汉式
 *
 * 保证类在内存中只有一个对象
 */
public class Singleton1 {
    //1、私有构造函数
    private Singleton1() {
    }

    //2、创建本类对象
    private static Singleton1 s = new Singleton1();

    //3、对外提供公共的访问方法
    public static Singleton1 getSingleton1() {
        return s;
    }
}
