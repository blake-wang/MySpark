package Test;

public class Test01 {
    public static void main(String[] args) {

        System.out.println("开始");
        if (args.length < 3) {
            System.err.println("<SOURCE> <SECOND> <DESC>");
            System.exit(1);
        }
        System.out.println("结束");
    }
}
