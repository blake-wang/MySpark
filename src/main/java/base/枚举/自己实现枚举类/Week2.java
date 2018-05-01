package base.枚举.自己实现枚举类;

public class Week2 {
    //枚举的第二种方式，有参构造
    public static final Week2 MON = new Week2("星期一");
    public static final Week2 TUE = new Week2("星期二");
    public static final Week2 WEN = new Week2("星期三");


    private String name;

    private Week2(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

}
