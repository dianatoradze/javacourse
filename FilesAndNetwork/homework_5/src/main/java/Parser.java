import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Parser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static TreeSet<Station> stations = new TreeSet<>();
    ;
    private static HashMap<String, Line> lines = new HashMap<>();
    private static TreeMap<Station, TreeSet<Station>> connections = new TreeMap<>();
    private static StationIndex stationIndex;

    public final String URL = "https://skillbox-java.github.io/";

    static void createJsonFile() throws IOException {

        stationIndex = new StationIndex();
        try (FileWriter file = new FileWriter("C:/Users/diana/Documents/Java/Программы/java_basics/FilesAndNetwork/homework_5/src/main/resources/map.json")) {
            file.write(GSON.toJson(stationIndex));
        }
    }

     static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/map.json"));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }


}
