package base.duo_tai;

/**
 * Created by wanglei on 2017/11/5.
 * 测试子类继承父类，方法调用，类型转换
 */
public class Test {
    public static void main(String[] args) {
        //p是parent引用，指向的是child，只能调用m1方法
        Parent p = new Child();
        //p.m1();

        //p2是patent，指向的是parent,只能调用m1()
        Parent p2 = new Parent();
        p2.m1();

        //c是child，继承了parent，可以调用m1(),m2()
        Child c = new Child();
        c.m1();
        c.m2();
        //p本身指向的就是child，所以p可以向下强转
        Child c2 = (Child)p;
        c2.m1();
        c2.m2();
        //p2本身指向的就是parent，所以p不能向下强转
        Child c3 = (Child)p2;
        c3.m1();
        c3.m2();
    }


}
