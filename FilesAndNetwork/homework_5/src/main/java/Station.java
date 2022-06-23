import java.util.HashMap;

public class Station implements Comparable<Station>
{
    private Line number;
    private String name;

    public Station(String name, HashMap<String, Line> line)
    {
        this.name = name;
        this.number = line;
    }

    public Line getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station)
    {
        int lineComparison = number.compareTo(station.getNumber());
        if(lineComparison != 0) {
            return lineComparison;
        }
        return name.compareToIgnoreCase(station.getName());
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString()
    {
        return name;
    }
}