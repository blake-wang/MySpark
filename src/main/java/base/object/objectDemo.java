package base.object;

/**
 * Created by bigdata on 18-1-3.
 */
public class objectDemo {
    public static void main(String[] args) {
        String str = "12345";
        System.out.println(str.hashCode());

        Student stu = new Student("wanglei",23);
        System.out.println(stu.toString());

    }
}
