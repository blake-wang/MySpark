package base.枚举.自己实现枚举类;

public class Test {

    public static void main(String[] args) {
        Week1 mon = Week1.MON;
        System.out.println(mon);

        Week1 tue = Week1.TUE;
        System.out.println(tue);

        Week1 wed = Week1.WED;
        System.out.println(wed);

        System.out.println("------------------------");

        Week2 mon2 = Week2.MON;
        System.out.println(mon2);

        Week2 tue2 = Week2.TUE;
        System.out.println(tue2);

        Week2 wed2 = Week2.WEN;
        System.out.println(wed2);

        System.out.println("------------------------");

        Week3 mon3 = Week3.MON;
        mon3.show();
        System.out.println(mon3);

        Week3 tue3 = Week3.TUE;
        System.out.println(tue3);

        Week3 wed3 = Week3.WEN;
        wed3.show();
        System.out.println(wed3);

    }
}
