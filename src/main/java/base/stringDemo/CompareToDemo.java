package base.stringDemo;

/**
 * compareTo方法，是按String字符串的字典顺序排序
 * <p>
 * 下面是按字典顺序比较的详细说明
 * <p>
 * a与b比较，返回结果 ：
 * 1、小于0，a在b前面
 * 2、大于0，a在b后面
 * 3、等于0，两个字符串相等
 */
public class CompareToDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcd";
        System.out.println("s1.compareTo(s2)" + s1.compareTo(s2));//前缀相同则比较长度，长度差-1
        System.out.println("s1.compareTo(s2)" + s1.compareTo("abcdefgh"));//长度差-5


        String s3 = "abc";
        String s4 = "ae";
        System.out.println("s3.compareTo(s4)" + s3.compareTo(s4));//只比较第一个不同的字符处b-e=-3


        String s5 = "abcdeg";
        String s6 = "acce";
        System.out.println("s5.compareTo(s6)" + s5.compareTo(s6));//b-c=-1

        String s7 = "abc";
        String s8 = "abb";
        System.out.println("s7.compareTo(s8)" + s7.compareTo(s8));//c-b=1

        String s9 = "abc";
        String s0 = "abaaaaaaaaaaaaa";
        System.out.println("s9.compareTo(s0)" + s9.compareTo(s0));//c-a=2只比较第一个不同的字符处，与长度无关

        String sa = "我";
        System.out.println("s9.compareTo(s0)" + s9.compareTo("喔"));//-2181因为是Unicode编码可以比较汉字
    }
}

