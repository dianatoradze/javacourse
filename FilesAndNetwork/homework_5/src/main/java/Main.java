
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String url = "https://skillbox-java.github.io/";
    private static StationIndex stationIndex;
    private static String path = "C:/Users/diana/Documents/Java/Проекты/homework_5/data";
    private static String pathFile = "src/main/resources/map.json";
    private static String pathJson = "src/main/resources/stations.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(StationIndex.class, new Serializer())
            .create();

    public static void main(String[] args) throws Exception {

        System.out.println("Схема маршрута метрополитена Москвы\n");
        System.out.println(loadDatesFromFile(path));
        getStationIndex(url);
        createJsonFile();

        getStationCount();

        String[] extensions1 = {"json"};
        List filesJson = DirectoriesFile.findFiles(Paths.get(path), extensions1);
        Station station = new Station(); // create stations.json
        List dateParse = loadDatesFromFile(path);
        if (filesJson.contains(dateParse)) {
            try (PrintWriter out = new PrintWriter(new FileWriter(pathJson))) {

                String jsonString = GSON.toJson(station);
                out.write(jsonString);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static List loadDatesFromFile(String path) {
        return getList(path);
    }

    static List getList(String path) {
        List date = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] fragments = line.split("\t");

                String dateFormat = "dd.MM.yyyy";
                date.add((new SimpleDateFormat(dateFormat)).parse(fragments[1])
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }

    private static void getStationIndex(String url) {
        stationIndex = new StationIndex();
        try {
            Document doc = Jsoup.connect(url).maxBodySize(0).get();
            Parser.addLines(doc);
            Parser.addStations(doc);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    static void createJsonFile() throws IOException {

        stationIndex = new StationIndex();
        String json = GSON.toJson(stationIndex);
        try (FileWriter file = new FileWriter(pathFile)) {
            file.write(json);
        }
    }

    static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();

    }
    static void getStationCount() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(getJsonFile());

            JSONObject stations = (JSONObject) object.get("stations");
            Parser.parseStations(stations);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
    

   



