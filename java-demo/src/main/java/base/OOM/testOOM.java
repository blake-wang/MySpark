package base.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigdata on 17-12-12.
 * 堆内存溢出
 */
public class testOOM {
    public static void main(String[] args) {
        int i = 0;
        List<Person> list = new ArrayList<>();
        while (true) {
            System.out.println(i++);
            list.add(new Person());
        }

    }

    public static class Person {

    }
}
