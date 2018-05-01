package base.枚举.enum实现枚举;

public enum Week2 {
    //第二种方式的枚举类，带参数
    MON("星期一"), TUE("星期二"), WED("星期三");

    private String name;

    private Week2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
