import java.util.ArrayList;
import java.util.List;

public class Line
{
    private String numberLine;
    private String name;


    public Line(Line number, String name)
    {
        this.numberLine = number;
        this.name = name;

    }

    public String getNumberLine()
    {
        return numberLine;
    }

    public String getName()
    {
        return name;
    }

}