import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

public class Serializer implements JsonSerializer<StationIndex> {
    public JsonElement serialize(StationIndex src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject result = new JsonObject();
        JsonArray lines = new JsonArray();
        JsonObject stations = new JsonObject();

        result.add("line", lines);
        result.add("stations", stations);


        for (Map.Entry<String, Line> entry : src.line.entrySet()) {
            JsonObject line = new JsonObject();
            line.add("number", new JsonPrimitive(entry.getValue().getNumber()));
            line.add("name", new JsonPrimitive(entry.getValue().getName()));
            lines.add(line);

            JsonArray stationsOnLine = new JsonArray();
            for (Station station : src.stations)
            {
                if (station.getLine().equals(entry.getValue())){
                    stationsOnLine.add(new JsonPrimitive(station.getName()));
                }
            }
            stations.add(entry.getValue().getNumber(), stationsOnLine);
        }



        return result;
    }
}
