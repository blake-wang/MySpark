package base.OOM;


/**
 * Created by bigdata on 17-12-12.
 * 借助CGLib使得方法区出现OOM异常
 */
public class JavaMethodAreaOOM {
//    public static void main(String[] args) {
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
//            enhancer.create();
//        }
//    }

    static class OOMObject {

    }
}
