package base.object;

/**
 * Created by bigdata on 18-1-3.
 * object对象
 * <p>
 * object中的equals方法是比较对象的地址值的，没有什么意义，我们需要重写，
 * 因为在开发中我们通常比较的是对象中的属性值，我们认为相同属性是同一个对象
 * <p>
 * ==好和equals方法的区别
 * ==是一个比较运算符号，既可以比较基本数据类型，也可以比较引用数据类型，基本数据类型比较的是值，引用数据类型比较的是地址值
 * equals方法是一个方法，只能比较引用数据类型，所有的对象都会继承Object类中的方法，如果没有重写Object类中的equals方法，
 * equals方法和==号比较引用数据类型无区别，重写后的equals方法比较的是对象中的属性
 */
public class ObjectDemo {
    public static void main(String[] args) {
        //getClass
        Class<? extends ObjectDemo> clazz = new ObjectDemo().getClass();
        System.out.println(clazz);
        String name = clazz.getName();
        System.out.println(name);

        //hashCode
        String str = "12345";
        System.out.println(str.hashCode());
        Double f1 = 12.99;
        System.out.println(f1.hashCode());

        //toString
        Student stu = new Student("wanglei", 23);
        System.out.println(stu.toString());

        //==
        int i1 = 6;
        int i2 = 8;
        System.out.println(i1 == i2);

        //equals
        String str1 = "wanglei";
        String str2 = "wanglei";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        Student stu1 = new Student("zhichao", 20);
        Student stu2 = new Student("zhangning", 26);
        System.out.println(stu1 == stu2);
        System.out.println(stu1.equals(stu2));


    }
}
