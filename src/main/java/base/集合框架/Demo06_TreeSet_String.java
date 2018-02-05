package base.集合框架;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by wanglei on 2018/2/4.
 * TreeSet
 * 需求：将字符串按照长度排序
 * <p>
 * 如何实现字符串按照字符串长度来排序？
 * 对于字符串的排序，默认是按照字典顺序来排序的
 */
public class Demo06_TreeSet_String {
    public static void main(String[] args) {

        TreeSet<String> ts = new TreeSet<>(new CompareByLength());   //Comparator c = new CompareByLength();
        ts.add("wanglei");
        ts.add("aixu");
        ts.add("hi");
        ts.add("aaaa");
        ts.add("zhichao");
        ts.add("c");
        System.out.println(ts);

    }
}

class CompareByLength extends Object implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int num = s1.length() - s2.length();   //字符串的长度是第一条件
        return num == 0 ? s1.compareTo(s2) : num;   //字符串的内容是第二条件
    }
}

