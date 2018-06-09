package redis.list;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by wanglei on 2017/5/18.
 * 使用场景：网页爬虫
 */
public class Crawler {
    //定义需要爬取的url list
    private static final String redisUrlsWillKey = "crawler:urls:will";
    //如果需要去重的话，可以使用set保存已经爬取过的url

    public static void main(String[] args)
            throws IOException, ParseException
    {
        //准备url
//        String startUrl = "http://www.huxiu.com/collections";
        String startUrl = "https://www.huxiu.com/active";
        String domain   = "https://www.huxiu.com/";
        //获取文章url
        getUrls(startUrl, domain);
        //处理url，下载文章的内容并打印
        parserUrl();

    }

    private static void parserUrl()
            throws IOException, ParseException
    {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //从右边弹出一个url
        while (true) {
            String  url     = jedis.rpop(redisUrlsWillKey);
            Article article = parser(url);
            System.out.println(article);
        }
    }

    private static Article parser(String url)
            throws IOException, ParseException
    {
        Document articleDocument = Jsoup.connect(url)
                                        .get();
        Article article = new Article();
        //封装作者的信息
        Elements author = articleDocument.getElementsByClass("author-name");
        article.setAuthor(StringUtil.isBlank(author.text())
                          ? "jingzhongyue"
                          : author.text());
        //抽取文章日期
        Elements date = articleDocument.getElementsByClass("article-time");
        article.setDate(StringUtil.isBlank(date.text())
                        ? new Date()
                        : DateUtil.getDate(date.text()));
        //抽取文章编号
        // http://www.huxiu.com/article/124698/1.html
        String id    = url.substring(29);
        int    index = id.indexOf("/");
        id = id.substring(0, index);
        article.setId(id);
        //抽取文章正文
        StringBuffer stringBuffer = new StringBuffer();
        Elements     contents     = articleDocument.getElementsByAttribute("id");
        for (Element element : contents) {
            String idTag = element.attr("id");
            if ("article_content".equals(idTag)) {
                Elements childs    = element.children();
                Elements pElements = childs.tagName("p");
                for (Element element2 : pElements) {
                    stringBuffer.append(element2.text());
                }
            }
        }
        return article;
    }

    private static void getUrls(String startUrl, String domain)
            throws IOException
    {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Document document = Jsoup.connect(startUrl)
                                 .get();
        Elements elements = document.getElementsByAttribute("href");
        for (Element element : elements) {
            String endUrl = element.attr("href");
            if (endUrl.contains("article")) {
                String url = domain + endUrl;
                System.out.println(url);
                jedis.lpush(redisUrlsWillKey, url);
            }
        }
    }
}
