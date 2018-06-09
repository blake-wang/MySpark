package HttpClientDemo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 抓去汽车之家汽车评测的数据
 */
public class AutoHomeCrawler {
    public static void main(String[] args) throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //声明httpGet请求对象
        HttpGet httpGet = new HttpGet("https://www.autohome.com.cn/bestauto");

        //使用HttpClient发起请求，获取response
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //判断相应的状态码是否是200
        if (response.getStatusLine().getStatusCode() == 200) {
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(html);

        }
    }
}
