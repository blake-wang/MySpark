package base.stringDemo;

/**
 * Created by wanglei on 2018/1/3.
 * 遍历字符串
 */
public class foreachStringDemo {
    public static void main(String[] args) {
        String str = "wo ai ni xiao xu xu !";

        //通过角标取字符遍历
        for (int i = 0; i < str.length(); i++) {
            //通过角标获取每一个字符
            char c = str.charAt(i);
            System.out.println(c);
        }

        //转换成字符数组再遍历
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
