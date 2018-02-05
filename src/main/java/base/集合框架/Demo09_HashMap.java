package base.集合框架;

import java.util.*;

/**
 * Created by wanglei on 2018/2/4.
 * HashSet   API使用示例
 */
public class Demo09_HashMap {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();

        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        


    }

    private static void demo4() {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);

        //获取键的集合
        Set<String> strings = map.keySet();

        //使用增强for循环获取每一个键和值
        for (String string : strings) {
            Integer integer = map.get(string);
            System.out.println(string + " ** " + integer);
        }

        //通过迭代器的方式获取每一个键和值
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();   //获取每一个键
            Integer value = map.get(key);   //根据键获取值
            System.out.println(key + " ** " + value);
        }
    }

    private static void demo3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);

        //获取所有的值
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println("*********************************");

        //获取所有的键
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }

        //获取集合的大小
        int size = map.size();
        System.out.println(size);
    }

    private static void demo2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);
        System.out.println(map);
        //根据键删除元素，返回键对应的值
        Integer value = map.remove("王五");
        System.out.println(map);
        System.out.println(value);

        //判断是否包含键
        boolean res = map.containsKey("张三");
        System.out.println(res);
        //判断是否包含值
        boolean res2 = map.containsValue(25);
        System.out.println(res2);

        boolean empty = map.isEmpty();
        System.out.println(empty);
    }

    private static void demo1() {
        Map<String, Integer> map = new HashMap<>();
        Integer i1 = map.put("张三", 23);
        Integer i2 = map.put("李四", 24);
        Integer i3 = map.put("王五", 25);
        Integer i4 = map.put("赵六", 26);
        //会覆盖掉相同键的值
        Integer i5 = map.put("张三", 27);
        System.out.println(map);

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5); //返回的是被覆盖的键对应的值

        //清空集合
        map.clear();
        System.out.println(map);
    }
}
