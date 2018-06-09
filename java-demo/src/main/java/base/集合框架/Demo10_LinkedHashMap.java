package base.集合框架;

import java.util.LinkedHashMap;

/**
 * Created by wanglei on 2018/2/5.
 */
public class Demo10_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("赵六", 26);
        lhm.put("李四", 24);
        lhm.put("张三", 23);
        lhm.put("王五", 25);
        lhm.put("赵六", 129);
        System.out.println(lhm);
    }

}
