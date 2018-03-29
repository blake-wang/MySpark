package UseClass;

import java.io.*;

/**
 * 文件拷贝
 * 读取文件内容，在写出文件内容要新文件
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
