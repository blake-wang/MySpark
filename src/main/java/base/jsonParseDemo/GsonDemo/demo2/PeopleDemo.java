package base.jsonParseDemo.GsonDemo.demo2;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/21.
 */
public class PeopleDemo {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        String str = gson.toJson(new PeopleBean("wanglei", 18));
        gson.toJson(str,new FileWriter("src/testData/wangleiJson.txt"));

        System.out.println(str);
    }
}
