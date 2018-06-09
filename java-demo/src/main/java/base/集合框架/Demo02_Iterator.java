package base.集合框架;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanglei on 2018/1/30.
 * 迭代器
 * <p>
 * 迭代器其实就是遍历，迭代器里面其实是有一个指针
 * <p>
 * 如果用Iterator遍历的时候，同时向集合中添加元素，就会发生并发修改异常ConcurrentModificationException
 * <p>
 * 要避免这个问题，就要用ListIterator，用这个迭代器就可以避免并发修改异常
 */
public class Demo02_Iterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("world");
        list.add("e");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            System.out.println(next);
            //这样会引起并发修改异常
            if (next.equals("b")) {
                list.add("hello");
            }
        }

    }
}
