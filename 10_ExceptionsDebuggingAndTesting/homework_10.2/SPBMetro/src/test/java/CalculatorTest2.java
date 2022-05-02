import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.ArrayList;
import java.util.List;

public class CalculatorTest2 extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        route.add(new Station("Площадь Маркса", line1));
        route.add(new Station("Студенческая", line1));
        route.add(new Station("Речной вокзал", line1));
        route.add(new Station("Березовая роща", line2));
        route.add(new Station("Площадь Маркса", line2));

        stationIndex = new StationIndex();
        line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        Station st1l3 = new Station("Приморская", line3);
        Station st2l3 = new Station("Василеостровская", line3);
        Station st3l3 = new Station("Гостиный двор", line3);

        line3.addStation(st1l3);
        line3.addStation(st2l3);
        line3.addStation(st3l3);
        Station st1l2 = new Station("Невский проспект", line2);
        Station st2l2 = new Station("Сенная площадь", line2);

        line3.addStation(st1l2);
        line3.addStation(st2l2);

        stationIndex.addStation(st1l3);
        stationIndex.addStation(st2l3);
        stationIndex.addStation(st3l3);
        stationIndex.addStation(st1l2);
        stationIndex.addStation(st2l2);

        List<Station> connection3to2 = new ArrayList<>();
        connection3to2.add(st3l3);
        connection3to2.add(st1l2);
        stationIndex.addConnection(connection3to2);
        routeCalculator = new RouteCalculator(stationIndex);

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        List<Station> route = routeCalculator.getShortestRoute(stationIndex.getStation("Приморская"), stationIndex.getStation("Сенная площадь"));

    }

    @Override
    protected void tearDown() throws Exception {

    }
}

