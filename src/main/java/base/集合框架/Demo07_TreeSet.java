package base.集合框架;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by wanglei on 2018/2/4.
 * <p>
 * 需求：在一个集合中存储了无序并且重复的字符串，定义一个方法，让其有序（字典顺序），并且还不能去除重复
 * <p>
 * 分析
 * 1、定义一个List集合，并存储重复的无序的字符串
 * 2、定义方法对其排序保留重复
 * 3、打印List集合
 */
public class Demo07_TreeSet {
    public static void main(String[] args) {
        //1、定义一个List集合
        ArrayList<String> list = new ArrayList<>();
        list.add("bb");
        list.add("bb");
        list.add("wanglei");
        list.add("aixu");
        list.add("zhichao");
        list.add("aaa");
        list.add("aaa");
        System.out.println(list);

        //2、定义一个方法，对其排序并保留重复
        sort(list);

        //3、打印List集合
        System.out.println(list);

    }

    /**
     * sort方法，排序并保留重复
     * 分析：
     * 1、创建TreeSet集合对象，因为String本身就具备比较功能，但是重复不会保留，所以我们用比较器
     * 2、将list集合中的所有元素添加到TreeSet集合中，对其排序，保留重复
     * 3、清空list集合
     * 4、将TreeSet集合中排好序的元素添加到list中
     *
     * @param list
     */
    private static void sort(List<String> list) {
        //1、创建TreeSet集合对象，因为String本身就具备比较功能，但是重复不会保留，所以我们用比较器
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {   //匿名内部类
            @Override
            public int compare(String s1, String s2) {
                int num = s1.compareTo(s2); //比较两个字符串内容
                return num == 0 ? 1 : num;  //当两个字符串相同时，不返回0，让返回1，这样就不会去除重复
            }
        });
        //2、将list集合中的所有元素添加到TreeSet集合中，对其排序，保留重复
        ts.addAll(list);
        //3、清空list集合
        list.clear();
        //4、将TreeSet集合中排好序的元素添加到list中
        list.addAll(ts);

    }
}
