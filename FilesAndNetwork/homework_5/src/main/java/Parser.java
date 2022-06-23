import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Parser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static HashSet<String> stations = new HashSet<>();;
    private static HashMap<String, Line> lines = new HashMap<>();
    private static TreeMap<Station, TreeSet<Station>> connections = new TreeMap<>();
    private static StationIndex stationIndex;

    public final String URL = "https://skillbox-java.github.io/";
    static void createJsonFile() throws IOException {

        stationIndex = new StationIndex(lines, stations);
        try (FileWriter file = new FileWriter("src/main/resources/map.json")) {
            file.write(GSON.toJson(stationIndex));
        }
    }

    static void parseLines(String lineName, HashMap<String, Line> lineNumbers) {
        Line line = new Line(lineNumbers.get(0), lineName);
        if (!lines.containsValue(line)) lines.put(line);
    }

    static void parseStation(String stationName, List<String> lineNumbers) {
        String lineId = lineNumbers.get(0);
        if (!stations.contains(lineId)) {
            stations.add(lineId);
            stations.get(lineId).add(stationName);
        } else stations.get(lineId).add(stationName);

    }

    static String parseURL(String path) {
        StringBuffer sb = new StringBuffer();
        try {

            List<String> urls = new ArrayList<>();
            Document document = Jsoup.connect("URL").maxBodySize(0).get();
//<span class="js-metro-line t-metrostation-list-header t-icon-metroln ln-1" data-line="1">Сокольническая
//                                            линия</span>
            Element lines = document.select(".js-metro-line").first(); //?
            urls.forEach(url -> sb.append(url).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    static void JsonParser() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(parseURL("URL"));

        Map<String, List<String>> stations = (Map<String, List<String>>) jsonObject.get("stations");
        for (String lineId : stations.keySet()) {
            JSONArray stationsArray = (JSONArray) stations.get(lineId);
            for (Line line : stationIndex.getLine()) {
                if (line.getName().equals(lineId)) {
                    System.out.println("Линия " + lineId + " " + line.getName() + " -> количество станций: " + stationsArray.size());

                }
            }
        }
}
