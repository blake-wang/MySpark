package base.JsonParseDemo.GsonDemo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by bigdata on 17-11-22.
 * Gson  的简单使用
 *
 *
 */
public class testGson {

    public static void main(String[] args) {

//        String str = "{\"content\":{\"operatime\":\"2017-07-19 17:20:01\",\"rolechgype\":\"1\",\"roleid\":\"12923556610888\",\"rolelevel\":null,\"rolename\":\"郦凝\",\"roletype\":\"神剑\",\"status\":\"1\"},\"title\":{\"exectime\":\"2017-07-19 17:20:01\",\"gameid\":\"\",\"gamelevel\":\"\",\"imei\":\"8FCB0C49-B05A-4186-8E6B-ACFE35CA289B\",\"ip\":\"182.134.206.133\",\"lid\":\"\",\"logclass\":\"BI_ROLE\",\"model\":\"iPhone 6 (A1549/A1586)\",\"network\":\"wifi\",\"os\":\"10.3.2\",\"roleid\":\"12923556610888\",\"rolelevel\":\"1\",\"servarea\":\"ly3009\",\"servareaname\":\"朋友玩#542服 长虹贯日\",\"tid\":\"\",\"userid\":\"jidong_594fcdbec3957f679e70eeedb8cb52cd\",\"userlevel\":\"1\",\"usertype\":\"\",\"ver\":\"10.3.2\"}}";


//        demo1();

        String ts = "{\n" +
                "  \"adv_id\": \"-1\",\n" +
                "  \"adv_name\": \"bi_adv_medium_click\",\n" +
                "  \"channel_main_id\": 13,\n" +
                "  \"channel_name\": \"\",\n" +
                "  \"imei\": \"\",\n" +
                "  \"ip\": \"121.69.15.18\",\n" +
                "  \"mac\": \"\",\n" +
                "  \"os\": \"1\",\n" +
                "  \"pkg_id\": \"5666Q16004\",\n" +
                "  \"ts\": 1515654038,\n" +
                "  \"ua\": \"iPhone 10.3.2\"\n" +
                "}";
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(ts, JsonObject.class);
        JsonElement ua = jsonObject.get("ua");
        String asString = ua.getAsString();
        System.out.println(asString);




    }

    private static void demo1() {
        Gson gson = new Gson();
        Integer integer = gson.fromJson("100", int.class);
        System.out.println(integer);
        Double aDouble = gson.fromJson("99.99", double.class);
        System.out.println(aDouble);
        Boolean aTrue = gson.fromJson("true", boolean.class);
        System.out.println(aTrue);
        String s = gson.fromJson("helloworld", String.class);
        System.out.println(s);
    }


}
