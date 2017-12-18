package base.stringDemo;

/**
 * Created by wanglei on 2017/12/17.
 */
public class stringDemo {
    public static void main(String[] args) {
        String str = "0";
        //截取长度超过字符串的长度，会报错
        String substring = str.substring(0, 10);
        System.out.println(substring);
    }
}
