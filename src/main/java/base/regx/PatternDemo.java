package base.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanglei on 2018/1/4.
 * Pattern Matcher
 *
 * 从大的字符串中找出需要的字符串
 */
public class PatternDemo {
    public static void main(String[] args) {
//        matchDemo();

        String s = "我的手机是18511866260，我曾用过18887654321，我还用过18812345678";
        String regex = "1[3578]\\d{9}";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        //根据正则表达式，去查找s中是否有符合正则表达式的子字符串
        boolean b = m.find();
        System.out.println(b);
        //根据正则表达式，取出符合正则表达式的第一个子字符串
        String group = m.group();
        System.out.println(group);

        System.out.println("==========================================");

        //查找出所符合正则表达式的子字符串
        while(m.find()){
            System.out.println(m.group());
        }
    }

    private static void matchDemo() {
        Pattern p = Pattern.compile("a*b");     //获取到正则表达式
        Matcher m = p.matcher("aaaaab");    //获取匹配器
        boolean b = m.matches();                //看是否能匹配，匹配就返回true
        System.out.println(b);
        System.out.println("aaaaab".matches("a*b")); //与上面代码效果相同
    }
}
