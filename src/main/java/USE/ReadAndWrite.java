package USE;

import java.io.*;

/**
 * Created by wanglei on 2018/3/26.
 * 读取一个文件，一行一行读取，再一行一行写入到另一个文件，可以用于文件这个转换和拷贝
 */
public class ReadAndWrite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\nextjson.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\copy3.json"));
        String line;
        while ((line = br.readLine()) != null) {    //如果一行一行的读， null 是结束标识符
            bw.write(line);
            bw.newLine();   //写出回车换行符，每写一行要记得换行
        }
        br.close();
        bw.close();
    }
}
