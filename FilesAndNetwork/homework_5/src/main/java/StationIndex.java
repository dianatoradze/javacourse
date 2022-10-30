import com.google.gson.annotations.SerializedName;

import java.util.*;

public class StationIndex {

    HashMap<String, Line> line;

    TreeSet<Station> stations;

    public StationIndex() {
        line = new HashMap<>();
        stations = new TreeSet<>();

    }

    public void addLine(Line line)
    {
        if (!this.line.containsKey(line.getNumber())) {
            this.line.put(line.getNumber(), line);
        }
    }
    public Line getLine(String number)
    {
        return line.get(number);
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
                "line " + line +
                ", stations=" + stations;
    }
}
