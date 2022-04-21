import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String site = "https://auto.drom.ru/";
        try {
//            parse(site);
            parseFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void parseFile() throws IOException {
        File input = new File("C:\\Users\\Kovalev\\Desktop\\MySite-master\\index.html");
        Document doc = Jsoup.parse(input, "windows-1251", "http://example.com/");
        System.out.println(doc.title());
        Elements carItems = doc.select(".head_white_content h3, .head_black_content h4");
        for (Element car_item: carItems) {
            System.out.println(car_item.text());
        }
        carItems = doc.select(".numeral h5");
        for (Element car_item: carItems) {
            System.out.println(car_item.text());
        }
        carItems = doc.select(".advantage p");
        for (Element car_item: carItems) {
            System.out.println(car_item.text());
        }
        carItems = doc.select("#filters li");
        for (Element car_item: carItems) {
            System.out.println(car_item.text());
        }
    }

    static void parse(String url) throws IOException {
        Document doc = Jsoup.parse(new URL(url).openStream(), "windows-1251", url);
        System.out.println(doc.title());

        System.out.println("\nМарки машин:");
        Elements carItems = doc.select(".css-u4n5gw span[data-ftid='component_cars-list-item_name']");
        for (Element car_item: carItems) {
            System.out.println(car_item.html());
        }
        System.out.println("\nОбъявления:");
        Elements adItems = doc.select(".css-1173kvb a[data-ftid='bulls-list_bull']");
        for (Element ad_item: adItems) {
            String title = ad_item.select("span[data-ftid='bull_title']").first().text();
            String price = ad_item.select("span[data-ftid='bull_price']").first().text();
            System.out.println(title + " - " + price + "p.");
        }
    }
}
