package base.集合框架;

import java.util.HashSet;

/**
 * Created by wanglei on 2018/2/2.
 * HashSet
 * <p>
 * 无序（存取顺序不一致），没有索引，不能存储重复元素
 */
public class Demo04_HashSet {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        boolean b1 = hs.add("a");
        boolean b2 = hs.add("a");   //当向set集合中存储重复元素的时候返回为false

        System.out.println(hs);
        System.out.println(b1);
        System.out.println(b2);

        String a = "a";
        String b = "a";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


    }
}
