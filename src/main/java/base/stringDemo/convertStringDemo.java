package base.stringDemo;

/**
 * Created by wanglei on 2018/1/4.
 *
 * 将string转换成其他数据类型
 */
public class convertStringDemo {
    public static void main(String[] args) {
        String s1 = "2";
        String s2 = "true";
        String s3 = "12.9";
        String s4 = "16.33";
        String s5 = "8888888888888";


        int i = Integer.parseInt(s1);
        System.out.println(i);

        boolean b = Boolean.parseBoolean(s2);
        System.out.println(b);

        float v = Float.parseFloat(s3);
        System.out.println(v);

        double v1 = Double.parseDouble(s4);
        System.out.println(v1);

        long l = Long.parseLong(s5);
        System.out.println(l);
    }
}
