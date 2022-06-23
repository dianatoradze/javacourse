import com.google.gson.annotations.SerializedName;

import java.util.*;


public class StationIndex {
    @SerializedName("lines")
    HashMap<String, Line> lines;
    @SerializedName("stations")
    TreeSet<Station> stations;
    @SerializedName("connections")
    TreeMap<Station, TreeSet<Station>> connections;

    public StationIndex(HashMap<String, Line> lines, HashSet<String> stations) {
        this.lines = lines;
        this.stations = stations;
        this.connections = connections;
    }


    public HashMap<String, Line> getLine() {
        return lines;
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
        Station query = new Station(name, getLine());
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
    }


}
