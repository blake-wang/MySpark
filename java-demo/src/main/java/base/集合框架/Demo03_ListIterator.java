package base.集合框架;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wanglei on 2018/1/30.
 * <p>
 * List专用迭代器
 * <p>
 * ListIterator
 * 遍历迭代器的时候，可以向迭代器中添加元素，等同于向集合中添加元素
 */
public class Demo03_ListIterator {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("world");
        list.add("d");
        list.add("e");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = (String) listIterator.next();
            System.out.println(next);

            if (next.equals("b")) {
                //添加元素的对象是迭代器
                listIterator.add("hello");
            }
        }
        System.out.println(list);


    }
}
