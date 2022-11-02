import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Station implements Comparable<Station>
{
    private Line line;
    private String name;
    @JsonDeserialize(using = DateHandler.class)
    private String date;
    private String depths;

    public Station(String name, Line line)
    {
        this.name = name;
        this.line = line;
    }

    public Station() {
        this.date = date;
        this.depths = depths;
    }


    public Station(Date date) {
        this.date = String.valueOf(date);
    }

    public Line getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }
    @Override
    public int compareTo(Station station) {

        int lineComparison = line.compareTo(station.getLine());
        if (lineComparison != 0) {
            return lineComparison;
        }


        return name.compareToIgnoreCase(station.getName());

    }

    @Override
    public boolean equals(Object obj) {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public  String toString()
    {
        return name + " line " + line;
    }
}