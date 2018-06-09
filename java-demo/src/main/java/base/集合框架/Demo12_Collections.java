package base.集合框架;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by wanglei on 2018/2/5.
 * Collections  集合工具类
 * sort  排序
 * binarysearch  二分查找
 */
public class Demo12_Collections {
    public static void main(String[] args) {
        //对List集合进行排序
//        sort();

        //二分查找
//        binarySearch();

        //查找最大值
//        max();

        //反转集合
//        reverse();

        //随机打乱集合，洗牌
//        shuffle();


    }

    private static void shuffle() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("e");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    private static void reverse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("e");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    private static void max() {
        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("b");
        list.add("d");
        list.add("d");
        list.add("a");
        list.add("e");

        System.out.println(Collections.max(list));
    }

    private static void binarySearch() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("e");

        System.out.println(Collections.binarySearch(list, "a"));

        System.out.println(Collections.binarySearch(list, "b"));
    }

    private static void sort() {
        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("b");
        list.add("d");
        list.add("d");
        list.add("a");
        list.add("e");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
