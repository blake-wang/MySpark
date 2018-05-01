package base.注解.自定义注解;

@Description("I am interface")
public class Person {

    @Description("I am interface method")
    public String name() {
        return null;
    }

    public int age() {
        return 0;
    }


    @Deprecated
    public void sing() {

    }
}
