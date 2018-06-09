package base.集合框架;

/**
 * Created by wanglei on 2018/1/29.
 * <p>
 * 数组
 * <p>
 * 基本数据类型数组，引用数据类型数组
 *
 * 数组里面可以存放基本数据类型，也可以存放引用数据类型；
 * 基本类型存储的是值。
 * 引用类型存放的是内存中的地址值。
 */
public class Demo01_Array {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student("志超",22);
        arr[1] = new Student("张丽",29);
        arr[2] = new Student("艾旭",26);

        for (Student student : arr) {
            System.out.println(student);
        }
    }
}


class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
