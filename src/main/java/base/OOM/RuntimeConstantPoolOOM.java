package base.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigdata on 17-12-12.
 * 运行时常量池导致的OOM异常
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持着常量池引用，压制Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10M的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
