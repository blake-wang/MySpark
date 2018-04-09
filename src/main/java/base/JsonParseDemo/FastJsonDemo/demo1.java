package base.JsonParseDemo.FastJsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by wanglei on 2018/1/21.
 * <p>
 * FastJson  使用简介
 * <p>
 * 入口类是  com.alibaba.fastjson.JSON
 * <p>
 * 常用静态方法：
 * public static final Object parse(String text);                                // 把JSON文本parse为JSONObject或者JSONArray
 * public static final JSONObject parseObject(String text);                      // 把JSON文本parse成JSONObject
 * public static final JSONArray parseArray(String text);                        // 把JSON文本parse成JSONArray
 * public static final T parseObject(String text, Class clazz);                  // 把JSON文本parse为JavaBean
 * public static final List parseArray(String text, Class clazz);                // 把JSON文本parse成JavaBean集合
 * public static final String toJSONString(Object object);                       // 将JavaBean序列化为JSON文本
 * public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
 * public static final Object toJSON(Object javaObject);                         // 将JavaBean转换为JSONObject或者JSONArray。
 */
public class demo1 {
    public static void main(String[] args) {

        String ts = "{\n" +
                "  \"adv_id\": \"1\",\n" +
                "  \"adv_name\": \"bi_adv_medium_click\",\n" +
                "  \"channel_main_id\": 13,\n" +
                "  \"channel_name\": \"\",\n" +
                "  \"imei\": \"\",\n" +
                "  \"ip\": \"121.69.15.18\",\n" +
                "  \"mac\": \"\",\n" +
                "  \"os\": \"2\",\n" +
                "  \"pkg_id\": \"5666Q16004\",\n" +
                "  \"ts\": 1515654038,\n" +
                "  \"ua\": \"iPhone 10.3.2\"\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(ts);
        System.out.println(jsonObject);

        String adv_id = jsonObject.getString("adv_id");
        System.out.println(adv_id);

        Integer adv_id1 = jsonObject.getInteger("adv_id");
        System.out.println(adv_id1);

        Integer os = jsonObject.getInteger("os");
        System.out.println(os);

        String ipp = jsonObject.getString("ipp");
        System.out.println(ipp);

        String adv_name = jsonObject.getString("adv_name");
        System.out.println(adv_name);

    }
}
