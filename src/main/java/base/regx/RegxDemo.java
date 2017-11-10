package base.regx;

/**
 * Created by wanglei on 2017/11/10.
 * 正则表达式的示例
 * Pattern：编译好的带匹配的模板(如：Pattern.compile("[a-z]{2}");/ / 取2个小写字母)
 * Matcher：匹配目标字符串后产生的结果(如：pattern.matcher("目标字符串");)
 * 字符串还有一个自带的matches方法用来判断目标字符串是否匹配给定的正则表达式，格式为：targetStr.matches(regex); 返回类型为boolean。
 */
public class RegxDemo {
    public static void main(String[] args) {
        //单个字符
        System.out.println("a".matches("."));
        //0-1个a
        System.out.println("a".matches("a?"));
        //1-N个a
        System.out.println("aaaa".matches("a+"));
        //0-N个a
        System.out.println("".matches("a*"));
        //1-N个q和1个0-9之间的数字
        System.out.println("qq6".matches("q+[0-9]"));
        //12-100个数字
        System.out.println("12312312312312312313".matches("\\d{12,100}"));
        //1-3个数字,分别以.分割
        System.out.println("3.2.1".matches("\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}"));
        //第一个数字0-2，第二个数字0-9，第三个数字0-9
        System.out.println("192".matches("[0-2][0-9][0-9]"));
        //3个任意空白
        System.out.println("\n\r\t".matches("\\s{3}"));
        //特殊字符需要转义
        System.out.println("\\".matches("\\\\"));
        //以h开头，中间有0-N个字符，最后以o结尾
        System.out.println("hello".matches("^h.*o$"));
        //以h开头，中间1-3个字母尾随一个o，接着空白连着0-N个字母并以d结尾
        System.out.println("hello world".matches("^h\\w{1,3}o\\s\\w*d$"));
        System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
        //以任意空白且不以换行开头为开头，并以换行结尾
        System.out.println("  \n".matches("^[\\s&&[^\\n]]*\\n$"));
        //0-N个字符，连接4个数字和一个字符
        System.out.println("aaa 1234b".matches(".*\\d{4}\\w"));

    }
}
