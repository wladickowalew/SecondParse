import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String site = "https://en.wikipedia.org/";
        try {
            parse(site);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void parse(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s",
                    headline.attr("title"),
                    headline.absUrl("href"));
        }
    }
}
