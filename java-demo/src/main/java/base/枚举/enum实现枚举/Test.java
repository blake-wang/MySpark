package base.枚举.enum实现枚举;


public class Test {
    public static void main(String[] args) {
        //枚举类默认实现了toString() 方法
        Week1 mon = Week1.MON;
        System.out.println(mon);

        Week1 tue = Week1.TUE;
        System.out.println(tue);

        System.out.println("--------------------------------------");

        Week2 mon2 = Week2.MON;
        System.out.println(mon2 + "--" + mon2.getName());

        Week2 tue2 = Week2.TUE;
        System.out.println(tue2 + "--" + tue2.getName());

        System.out.println("---------------------------------------");
        Week3 mon3 = Week3.WED;
        mon3.show();

        System.out.println("--------------------------------------");

        switch (mon3) {
            case MON:
                System.out.println("星期一");
                break;
            case TUE:
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
        }
    }
}
