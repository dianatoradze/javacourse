
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;


public class Main {


    private static StationIndex stationIndex;
    public static void main(String[] args) throws IOException, ParseException {

        Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
        Element table = document.select("table").get(3);
        Elements rows = table.select("tr");

            System.out.println("Схема маршрута метрополитена Москвы\n");



        rows.stream().skip(1).forEach((row) -> {

            Elements cols = row.select("td");
            String stationName = cols.get(1).text();
            String lineName = cols.get(0).child(1).attr("title");
            List<String> lineNumbers = cols.get(0).children().eachText();
            List<String> connectionsLineName = cols.get(0).children().eachAttr("title");
            List<String> connectionsNumber = cols.get(3).children().eachText();

            Parser.parseStation(stationName, lineNumbers, connectionsLineName);
            Parser.parseLines(lineName, lineNumbers);

        });

        Parser.createJsonFile();
        Parser.JsonParser();
        }





    }

