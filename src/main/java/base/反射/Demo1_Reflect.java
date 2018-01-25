package base.反射;

/**
 * Created by wanglei on 2018/1/25.
 * 获取Class对象的三种方式
 *
 *
 */
public class Demo1_Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式1：
        Class clazz1 = Class.forName("base.反射.Dog");
        //方式2：
        Class clazz2 = Dog.class;
        //方式3
        Dog d = new Dog();
        Class clazz3 = d.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);

    }
}
