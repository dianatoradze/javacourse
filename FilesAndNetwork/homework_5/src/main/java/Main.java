
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    private static String url = "https://skillbox-java.github.io/";
    private static StationIndex stationIndex;

    private static String dataFile = "C:/Users/diana/Documents/Java/Программы/java_basics/FilesAndNetwork/homework_5/src/main/resources/map.json";
    public static void main(String[] args) throws Exception {

        System.out.println("Схема маршрута метрополитена Москвы\n");
        Parser.createJsonFile();

        getStationIndex(url);
        getStationCount();

    }
        private static void getStationIndex (String url)
        {
            stationIndex = new StationIndex();
            try
            {
                Document doc = Jsoup.connect(url).maxBodySize(0).get();
                addLines(doc);
                addStations(doc);

            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }

        private static void addLines(Document doc)
        {
            for (Element row : doc.select("js-metro-line")) //add Lines
            {

                if (row.select("t-metrostation-list-header").text().equals("")){
                    continue;
                }
                List<String> nameLine = row.select("t-icon-metroln").select("span").eachAttr("title");
                List<String> numberLine = row.select("data-line").select("span").eachText();

                if (nameLine.get(0) == null || numberLine.get(0) == null)
                {
                    continue;
                }
                Line line = new Line(numberLine.get(0), nameLine.get(0));
                stationIndex.addLine(line);


                if (nameLine.size() > 1){
                    Line line2 = new Line(numberLine.get(1), nameLine.get(1));
                    stationIndex.addLine(line2);
                }
            }
        }

        private static void addStations(Document doc)
        {
            for (Element row : doc.select("js-metro-stations"))  //add Station
            {

                if (row.select("t-metrostation-list-table").text().equals("")){
                    continue;
                }
                List<String> nameLine = row.select("[class=name]").select("span").eachAttr("title");
                List<String> numberLine = row.select("data-line").select("span").eachText();
                String nameStation = row.select("t-icon-metroln").select("span").first().text();

                Line line = new Line(numberLine.get(0), nameLine.get(0));
                Station station = new Station(nameStation, line);
                stationIndex.addStation(station);

                if (nameLine.size() > 1){
                    Line line2 = new Line(numberLine.get(1), nameLine.get(1));
                    Station station2 = new Station(nameStation, line2);
                    stationIndex.addStation(station2);
                }
            }
        }

    private static void getStationCount()
    {
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseStations(JSONObject stationsObject)
    {

        stationsObject.keySet().forEach(lineNumberObject ->
        {
            String lineNumber = (String) lineNumberObject;
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);

            System.out.println("Номер линии - " + lineNumber + ", всего станций - " + stationsArray.size());
        });
    }

    private static String getJsonFile()
    {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(builder::append);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    }

