import com.google.gson.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class Parser {

    private static TreeSet<Station> stations = new TreeSet<>();
    ;
    private static HashMap<String, Line> lines = new HashMap<>();
    private static TreeMap<Station, TreeSet<Station>> connections = new TreeMap<>();

    private static String pathFile = "src/main/resources/map.json";

    public final String URL = "https://skillbox-java.github.io/";

    private static StationIndex stationIndex;
    static void addLines(Document doc) {


        for (Element row : doc.select("div[id=metrodata]")) //add Lines
        {
            if (row.select("js-metro-line").text().equals("")) {
                continue;
            }
            List<String> nameLine = Collections.singletonList(row.attr("data-line"));
            List<String> numberLine = Collections.singletonList(row.text());
            if (nameLine.get(0) == null || numberLine.get(0) == null) {
                continue;
            }
            Line line = new Line(numberLine.get(0), nameLine.get(0));
            stationIndex.addLine(line);

            if (nameLine.size() > 1) {
                Line line2 = new Line(numberLine.get(1), nameLine.get(1));
                stationIndex.addLine(line2);
            }
        }
    }

    static void addStations(Document doc) {
        for (Element row : doc.select("div[id=metrodata]"))  //add Station
        {
            if (row.select("js-metro-stations").text().equals("")) {
                continue;
            }
            List<String> nameLine = Collections.singletonList(row.attr("data-line"));
            List<String> numberLine = Collections.singletonList(row.text());
            Elements nameStations = row.getElementsByClass("name");

            String nameStation = nameStations.text();

            Line line = new Line(numberLine.get(0), nameLine.get(0));
            Station station = new Station(nameStation, line);
            stationIndex.addStation(station);
            if (nameLine.size() > 1) {
                Line line2 = new Line(numberLine.get(1), nameLine.get(1));
                Station station2 = new Station(nameStation, line2);
                stationIndex.addStation(station2);
            }
        }
    }

    static void parseStations(JSONObject stationsObject) {

        stationsObject.keySet().forEach(lineNumberObject ->
        {
            String lineNumber = (String) lineNumberObject;
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);

            System.out.println("Номер линии - " + lineNumber + ", всего станций - " + stationsArray.size());
        });
    }
}
