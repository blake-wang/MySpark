package base.stringDemo;

/**
 * Created by bigdata on 18-1-4.
 * <p>
 * String 的 split方法有两个重载方法
 * 第一个只有一个参数
 * 第二个有两个参数
 * <p>
 * 要注意第二个参数的用法
 */
public class splitDemo {
    public static void main(String[] args) {
        String str = "boo:and:foo";
        String[] split = str.split(":");
        for (String s : split) {
            System.out.println(s);
        }

        System.out.println("===================================");
        String[] split1 = str.split(":", -1);
        for (String s : split1) {
            System.out.println(s);
        }
        System.out.println("===================================");

        String str2 = "2017-12-26 00:00:56,792 [INFO] root: bi_order ||A1712266N2186276|2|1148071|pyw281469325|2017-12-26 00:00:56|2560|17|0|6|6|6|0|2||0|0|1148071|0|||6||866119032471055&6df54fc145689310&02:00:00:00:00:00||0||";
        String[] split2 = str2.split("\\|");
        System.out.println(split2.length);
        for (String s : split2) {
            System.out.print(s + "=");
        }
        System.out.println();
        System.out.println("===================================");
        String[] split3 = str2.split("\\|", -1);
        System.out.println(split3.length);
        for (String s : split3) {
            System.out.print(s + "=");
        }
    }
}
