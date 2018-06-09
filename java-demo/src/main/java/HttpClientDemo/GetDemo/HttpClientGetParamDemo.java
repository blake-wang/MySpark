package HttpClientDemo.GetDemo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import scala.sys.process.ProcessBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 有参数的get请求
 */
public class HttpClientGetParamDemo {
    public static void main(String[] args) throws URISyntaxException {
        //创建HttpClient对象，相当于浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建URIBuilder设置参数
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s").setParameter("wd", "httpclient");
        URI uri = uriBuilder.build();
        System.out.println(uri);

        //创建HttpGet对象，相当于输入请求地址
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，相当于浏览器按回车，返回response
            response = httpClient.execute(httpGet);

            //判断状态200表是正常请求
            if (response.getStatusLine().getStatusCode() == 200) {
                String html = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println("请求成功，打印的数据是：" + html.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

