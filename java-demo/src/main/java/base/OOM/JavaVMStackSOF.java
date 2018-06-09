package base.OOM;

/**
 * Created by bigdata on 17-12-12.
 * VM栈和本地方法栈OOM测试（仅作为第1点测试程序）
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
//            e.printStackTrace();
            throw e;
        }
    }
}
