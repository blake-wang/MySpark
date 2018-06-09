package base.集合框架;

import java.util.TreeSet;

/**
 * Created by wanglei on 2018/2/2.
 * TreeSet集合会对元素进行排序，同时能保证元素的唯一
 * 要想实现TreeSet的排序功能：
 * 1、基本数据类型都实现了cpmparable接口
 * 2、自定义类要实现Comparable接口，重写CompareTo方法
 */
public class Demo05_TreeSet {
    public static void main(String[] args) {
//        demo1();

        TreeSet<People> ts = new TreeSet();
        ts.add(new People("赵六", 26));
        ts.add(new People("王五", 25));
        ts.add(new People("赵六", 29));
        ts.add(new People("张三", 23));
        ts.add(new People("邓", 99));
        ts.add(new People("丽", 88));
        ts.add(new People("丽", 77));
        ts.add(new People("周七", 24));
        ts.add(new People("李四", 24));

        System.out.println(ts);

        System.out.println("张" + 0);  //其实是一个字符串
        System.out.println('邓' + 0);  //返回的是uni码表对应的编码
        System.out.println('丽' + 0);

        System.out.println("赵六".length());

    }

    private static void demo1() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(1);
        ts.add(1);
        ts.add(2);
        ts.add(2);
        ts.add(3);
        ts.add(3);
        System.out.println(ts);
    }
}

class People implements Comparable<People> {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public int compareTo(People o) {
//        int num = this.age - o.age; //年龄是比较的主要条件
//        return num == 0 ? this.name.compareTo(o.name) : num;    //姓名是比较的次要条件
//    }


//    public int compareTo(People o) {
//        int num = this.name.compareTo(o.name);  //姓名是主要条件
//        return num == 0 ? this.age - o.age : num;   //年龄是次要条件
//    }
//

    @Override
    public int compareTo(People o) {
        int length = this.name.length() - o.name.length();  //姓名的长度是首要条件
        int num = (length == 0 ? this.name.compareTo(o.name) : length); //姓名是内容是第二条件
        return num == 0 ? this.age - o.age : num;   //年龄是第三条件
    }
}
