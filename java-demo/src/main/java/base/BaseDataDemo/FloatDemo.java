package base.BaseDataDemo;

/**
 * Created by bigdata on 18-1-29.
 * Float 单精度浮点数
 *
 */
public class FloatDemo {
    public static void main(String[] args) {
        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println("------------------------------------------");

        //要用f标注出来，在运算中会自动提升为double类型
        float f = 10.50f;

        float v = f / 2.2f;
        System.out.println(v);


    }
}
