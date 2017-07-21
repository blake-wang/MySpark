package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JSJSB-0071 on 2017/7/21.
 */
public class FileUtil {
    public static void main(String[] args) {
        String filePath = "D:\\work\\0721in\\11_android.txt";
        String newFilePath = "D:\\work\\0721out\\我疯了.txt";
//        readFile(filePath);
        readFileAndWrite(filePath, newFilePath);
    }

    //读取文件，并且指定编码格式
    public static List<String> readFile(String filePath) {
        File readFile = new File(filePath);
        InputStream in = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        List<String> list = new ArrayList<String>();
        try {
            in = new BufferedInputStream(new FileInputStream(readFile));
            //如果你文件以utf-8编码的就按这个编码来读取，不然中文会读取到乱码
            ir = new InputStreamReader(in, "utf-8");
            br = new BufferedReader(ir);
            String line = "";
            //一行一行读取
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ir != null) {
                try {
                    ir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;

    }

    //读取文件，并且指定编码格式，将文件输出
    public static void readFileAndWrite(String filePath, String newFilePath) {
        OutputStream out = null;
        OutputStreamWriter ow = null;
        BufferedWriter bw = null;
        File newFile = new File(newFilePath);
        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            out = new FileOutputStream(newFile);
            ow = new OutputStreamWriter(out, "utf-8");
            bw = new BufferedWriter(ow);
            String line = "";
            List<String> lines = readFile(filePath);
            for (int i = 0; i < lines.size(); i++) {
                line = lines.get(i);
                bw.write(line);
                if (i != lines.size() - 1) {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ow != null) {
                try {
                    ow.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
