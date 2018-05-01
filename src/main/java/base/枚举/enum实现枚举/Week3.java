package base.枚举.enum实现枚举;

public enum Week3 {
    //第三种方式的枚举类，带参数，带方法
    MON("星期一") {
        @Override
        public void show() {
            System.out.println("星期一");
        }
    }, TUE("星期二") {
        @Override
        public void show() {
            System.out.println("星期二");
        }
    }, WED("星期三") {
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
