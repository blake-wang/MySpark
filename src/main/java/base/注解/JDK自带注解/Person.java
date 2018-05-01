package base.注解.JDK自带注解;

public interface Person {
    public String name();

    public int age();

    @Deprecated
    public void sing();
}
