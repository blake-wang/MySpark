package udf;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.spark.sql.api.java.UDF2;

/**
 * Created by bigdata on 18-1-22.
 * 取出json字符串中的数组中的数据
 *
 * 第一个参数接受的是一个json字符串
 * 第二个参数接收的是字符串
 */
public class GetJsonObjectUDF implements UDF2<String, String, String> {
    //"{\"endAge\":[\"50\"],\"endDate\":[\"2016-06-21\"],\"startAge\":[\"10\"],\"startDate\":[\"2016-06-21\"]}"


    @Override
    public String call(String json, String field) throws Exception {
        String value = null;
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            value = jsonObject.getJSONArray(field).getString(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
