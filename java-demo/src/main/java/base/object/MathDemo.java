package base.object;

/**
 * Created by wanglei on 2018/1/4.
 * Math类
 */
public class MathDemo {
    public static void main(String[] args) {
        //pi
        double pi = Math.PI;
        System.out.println(pi);

        //abs  取绝对值
        System.out.println(Math.abs(-10));

        //ceil 天花板,向上取整
        System.out.println(Math.ceil(12.3));
        System.out.println(Math.ceil(12.99));

        //floor 地板，向下取整
        System.out.println(Math.floor(12.3));
        System.out.println(Math.floor(12.99));

        //Max  取大值
        System.out.println(Math.max(14, 79));

        //pow  求2的3次方
        System.out.println(Math.pow(2, 3));

        //random 生成0.0 ~ 1.0之间的随机小数，包括0.0，不包括1.0
        System.out.println(Math.random());

        //round  四舍五入
        System.out.println(Math.round(12.69));
        System.out.println(Math.round(12.3f));

        //sqrt  开平方
        System.out.println(Math.sqrt(9));
    }
}
