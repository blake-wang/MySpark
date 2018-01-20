package base.json;

import com.google.gson.Gson;

/**
 * Created by bigdata on 18-1-20.
 * 从文件或者网络传输中，获取的是一个json字符串
 *
 * json字符串有两种方式：
 * 一个对象： "{}"
 * 一个数组： "[]"
 *
 * 用gson解析
 *
 *
 */
public class GameRuleDemo {
    public static void main(String[] args) {
        String str = "{\"content\":{\"operatime\":\"2017-07-19 17:20:01\",\"rolechgype\":\"1\",\"roleid\":\"12923556610888\",\"rolelevel\":null,\"rolename\":\"郦凝\",\"roletype\":\"神剑\",\"status\":\"1\"},\"title\":{\"exectime\":\"2017-07-19 17:20:01\",\"gameid\":\"\",\"gamelevel\":\"\",\"imei\":\"8FCB0C49-B05A-4186-8E6B-ACFE35CA289B\",\"ip\":\"182.134.206.133\",\"lid\":\"\",\"logclass\":\"BI_ROLE\",\"model\":\"iPhone 6 (A1549/A1586)\",\"network\":\"wifi\",\"os\":\"10.3.2\",\"roleid\":\"12923556610888\",\"rolelevel\":\"1\",\"servarea\":\"ly3009\",\"servareaname\":\"朋友玩#542服 长虹贯日\",\"tid\":\"\",\"userid\":\"jidong_594fcdbec3957f679e70eeedb8cb52cd\",\"userlevel\":\"1\",\"usertype\":\"\",\"ver\":\"10.3.2\"}}";

        Gson gson = new Gson();
        GameRule gameRule = gson.fromJson(str, GameRule.class);
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
