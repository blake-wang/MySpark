package base.枚举.自己实现枚举类;

public abstract class Week3 {
    //枚举的第三种方式，有参构造
    public static final Week3 MON = new Week3("星期一") {
        @Override
        public void show() {
            System.out.println("星期一");
        }
    };
    public static final Week3 TUE = new Week3("星期二") {
        @Override
        public void show() {
            System.out.println("星期二");
        }
    };
    public static final Week3 WEN = new Week3("星期三") {
        @Override
        public void show() {
            System.out.println("星期三");
        }
    };


    private String name;

    private Week3(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract void show();
}
