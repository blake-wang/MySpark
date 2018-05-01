package base.注解.自定义注解;


@Description("I am Child class annotation")
public class Child extends Person {


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
