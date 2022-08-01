import com.google.gson.annotations.SerializedName;

import java.util.*;

public class StationIndex {
    @SerializedName("lines")
    HashMap<String, Line> lines;
    @SerializedName("stations")
    TreeSet<Station> stations;

    public StationIndex() {
        lines = new HashMap<>();
        stations = new TreeSet<>();

    }

    public void addLine(Line line)
    {
        if (!lines.containsKey(line.getNumber())) {
            lines.put(line.getNumber(), line);
        }
    }
    public Line getLine(String number)
    {
        return lines.get(number);
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }
    public Station getStation(String name) {
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public Station getStation(String name, String lineNumber) {
        Station query = new Station(name, getLine(lineNumber));
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
    }

    @Override
    public String toString() {
        return
                "lines " + lines +
                ", stations=" + stations;
    }
}
