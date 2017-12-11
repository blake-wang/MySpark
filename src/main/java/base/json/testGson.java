package base.json;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bigdata on 17-11-22.
 */
public class testGson {

    public static void main(String[] args) {
        String str = "{\"content\":{\"operatime\":\"2017-07-19 17:20:01\",\"rolechgype\":\"1\",\"roleid\":\"12923556610888\",\"rolelevel\":null,\"rolename\":\"郦凝\",\"roletype\":\"神剑\",\"status\":\"1\"},\"title\":{\"exectime\":\"2017-07-19 17:20:01\",\"gameid\":\"\",\"gamelevel\":\"\",\"imei\":\"8FCB0C49-B05A-4186-8E6B-ACFE35CA289B\",\"ip\":\"182.134.206.133\",\"lid\":\"\",\"logclass\":\"BI_ROLE\",\"model\":\"iPhone 6 (A1549/A1586)\",\"network\":\"wifi\",\"os\":\"10.3.2\",\"roleid\":\"12923556610888\",\"rolelevel\":\"1\",\"servarea\":\"ly3009\",\"servareaname\":\"朋友玩#542服 长虹贯日\",\"tid\":\"\",\"userid\":\"jidong_594fcdbec3957f679e70eeedb8cb52cd\",\"userlevel\":\"1\",\"usertype\":\"\",\"ver\":\"10.3.2\"}}";
        String json1 = "{\"name\":\"wanglei\",\"age\":18}";
//        testFromJson(str);
//        testToJson();
        try {
            JSONObject js = new JSONObject(json1);
            String name = js.getString("name");
            int age = js.getInt("age");
            System.out.println("name : "+name);
            System.out.println("age : "+age);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private static void testToJson() {
        Gson gson = new Gson();
        String str = gson.toJson(new People("wanglei", 18));
        System.out.println(str);
    }

    private static void testFromJson(String string) {
        Gson gson = new Gson();
        GameRule gameRule = gson.fromJson(string, GameRule.class);
        System.out.println(gameRule.getContent());
        System.out.println(gameRule.getContent().getOperatime());
        System.out.println(gameRule.getContent().getRolechgype());
        System.out.println(gameRule.getContent().getRoleid());
        System.out.println(gameRule.getContent().getRolelevel());
        System.out.println(gameRule.getContent().getRolename());
        System.out.println(gameRule.getContent().getRoletype());
        System.out.println(gameRule.getContent().getStatus());
    }
}
