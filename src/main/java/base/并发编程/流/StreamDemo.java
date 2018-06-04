package base.并发编程.流;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("abc");
        ls.add("def");
        ls.add("ddd");
        ls.add("eee");
        ls.add("def");
        ls.add("cba");
        ls.add("hello");

        //max：终端操作
//        Optional<String> max =  ls.stream().max(String::compareTo);
//        System.out.println(max.get());

        //sorted 中间操作
        //forEach 终端操作
        ls.stream().sorted().forEach(e -> System.out.println(e));

        System.out.println(ls.stream().distinct().count());


    }
}
