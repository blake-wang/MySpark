package base.注解.自定义注解;

import base.注解.JDK自带注解.Person;

@Description("I am Child class annotation")
public class Child implements Person {


    @Override
    @Description("I am Child method annotation")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {
        System.out.println("哎嘘在唱歌");
    }
}
