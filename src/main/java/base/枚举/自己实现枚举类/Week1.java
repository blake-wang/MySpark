package base.枚举.自己实现枚举类;

public class Week1 {

    //枚举的第一种方式，无参构造
    public static final Week1 MON = new Week1();
    public static final Week1 TUE = new Week1();
    public static final Week1 WED = new Week1();

    //私有构造函数，不让其他类创建本类对象
    private Week1() {
    }


}
