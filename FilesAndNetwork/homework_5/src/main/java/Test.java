import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Схема маршрута метрополитена Москвы\n");
        Document doc = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();
        Elements row = doc.getElementsByClass("js-metro-line");
        Elements stations = doc.getElementsByClass("name");
        Elements connections = doc.getElementsByClass("t-metrostation-list-table");
        System.out.println(connections.text() + "\n"); // список станций по линиям
//        for (Element e1 : row) {
//            System.out.print(e1.attr("data-line") + "\t"); //номера линий
//
//            System.out.println(e1.text());// название линий
//
//        }

        Elements table = doc.select("div[id=metrodata]");
        //System.out.println(e2.text());// название всех станций
        //System.out.println(table.text());//все линии и станции

    }



}
