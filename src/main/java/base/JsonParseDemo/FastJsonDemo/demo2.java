package base.JsonParseDemo.FastJsonDemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by bigdata on 18-1-22.
 */
public class demo2 {
    public static void main(String[] args) {
        String str = "{\"endAge\":[\"50\"],\"endDate\":[\"2016-06-21\"],\"startAge\":[\"10\"],\"startDate\":[\"2016-06-21\"]}";


        //将json字符串转换成json对象
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);

        //获取json数组
        JSONArray startDate = jsonObject.getJSONArray("startDate");
        System.out.println(startDate);

        //根据角标获取数组中的元素
        String string = startDate.getString(0);
        System.out.println(string);
    }
}
