import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Paths;


public class Test {
    private static String path = "C:/Users/diana/Documents/Java/Проекты/homework_5/data";
    public static void main(String[] args) throws Exception {
        System.out.println("Схема маршрута метрополитена Москвы\n");
        Document doc = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();
        Elements row = doc.getElementsByClass("js-metro-line");
        Elements stations = doc.getElementsByClass("name");
        Elements connections = doc.getElementsByClass("t-metrostation-list-table");
        //System.out.println(connections.text() + "\n"); // список станций по линиям
//        for (Element e1 : connections) {
//            System.out.print(e1.attr("data-line") + "\t"); //номера линий

//            System.out.println(e1.text());// название линий
//
//        }
        //Gson g = new Gson();
        String json = DirectoriesFile.nameFile(DirectoriesFile.findFiles(Paths.get(path), new String[]{"json"}));
        //Station station = g.fromJson(json, Station.class);
        ObjectMapper mapper = new ObjectMapper();
        Station stationParse = mapper.readValue(json, Station.class);
        System.out.println("Input json string");
        System.out.println(json);
        System.out.println("Generated java class: ");
        //System.out.println(stationParse);

        Elements table = doc.select("div[id=metrodata]");
        //System.out.println(e2.text());// название всех станций
        //System.out.println(table.text());//все линии и станции

    }

}
