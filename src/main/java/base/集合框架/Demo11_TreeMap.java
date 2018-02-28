package base.集合框架;

import java.util.TreeMap;

/**
 * Created by wanglei on 2018/2/5.
 */
public class Demo11_TreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("赵六", 26);
        tm.put("张三", 23);
        tm.put("李四", 24);
        tm.put("王五", 25);
        tm.put("赵六", 29);
        tm.put("周七", 33);

        System.out.println(tm);
    }
}
