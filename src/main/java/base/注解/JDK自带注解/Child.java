package base.注解.JDK自带注解;

public class Child implements Person {

    //override肯定是覆盖了父类的方法
    @Override
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
