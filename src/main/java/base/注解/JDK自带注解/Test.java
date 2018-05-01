package base.注解.JDK自带注解;

public class Test {
    public static void main(String[] args) {
        sing();
    }

    @SuppressWarnings("deprecation")
    public static void sing() {
        Person p = new Child();
        p.sing();
    }
}
