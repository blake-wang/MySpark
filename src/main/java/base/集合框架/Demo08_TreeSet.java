package base.集合框架;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by wanglei on 2018/2/4.
 * 需求：将字符串中的字符按字典顺序排序并保留重复，然后输出新的字符串
 * <p>
 * 1、将字符串转换为字符数组
 * 2、定义TreeSet集合，传入比较器对字符排序并保留重复
 * 3、遍历字符数组，将每一个字符存储在TreeSet集合中
 * 4、遍历TreeSet集合，打印每一个字符
 */
public class Demo08_TreeSet {
    public static void main(String[] args) {

        String str = "shenghuoyidinghuiyuelaiyuehao";
        System.out.println(str);
        //1、将字符串转换为字符数组
        char[] arr = str.toCharArray();
        //2、定义TreeSet集合，传入比较器对字符排序并保留重复
        TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                //int num = c1 - c2;  //自动拆箱
                int num = c1.compareTo(c2);
                return num == 0 ? 1 : num;  //去除重复
            }
        });

        //3、遍历字符数组，将每一个字符存储在TreeSet集合中
        for (char c : arr) {
            ts.add(c);  //自动类型提升，自动装箱
        }

        //4、遍历TreeSet集合，打印每一个字符
        for (Character c : ts) {
            System.out.print(c);
        }


    }
}
