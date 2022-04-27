import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {
    List<Station> oneTheLine;
    List<Station> oneConnection;
    List<Station> twoConnection;
    RouteCalculator calculator;

    Station st1l3;
    Station st1l2;
    Station st2l2;
    Station st1l5;
    Station st2l5;
    Station st3l3;
    @Override
    protected void setUp() throws Exception {

        StationIndex stationIndex = new StationIndex();
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        Line line5 = new Line(3, "Пятая");
//      добавление линии

        st1l3 = new Station("Приморская", line3);
        Station st2l3 = new Station("Василеостровская", line3);
        st3l3 = new Station("Гостиный двор", line3);

//      добавление станции на линии

        st1l2 = new Station("Невский проспект", line2);
        st2l2 = new Station("Сенная площадь", line2);


        st1l5 = new Station("Садовая", line5);
        st2l5 = new Station("Звенигородская", line5); // проверить пересадки


        Stream.of(line2, line3, line5).forEach(stationIndex::addLine);
        Stream.of(st1l3, st2l3, st3l3, st1l2,st2l2, st1l5, st2l5)
                .peek(s -> s.getLine().addStation(s)).forEach(stationIndex::addStation);
        stationIndex.addConnection(Stream.of(st3l3, st1l2).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(st2l2, st1l5).collect(Collectors.toList()));

        stationIndex.getConnectedStations(st2l2); //проверить линии Сенная-Садовая

        stationIndex.getConnectedStations(st1l5);

        calculator = new RouteCalculator(stationIndex);

        //тестовые маршруты
        oneTheLine = Stream.of(st1l3, st2l3, st3l3).collect(Collectors.toList());
        oneConnection = Stream.of(st1l3, st2l3, st3l3, st1l2, st2l2)
                .collect(Collectors.toList());
        twoConnection = Stream
                .of(st1l3, st2l3, st3l3, st1l2, st2l2,st1l5, st2l5)
                .collect(Collectors.toList());

    }
    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(oneTheLine);
        double expected = 5;
        assertEquals(expected, actual);
    }
    public void testCalculateConnection() {
        double actual = RouteCalculator.calculateDuration(twoConnection);
        double expected = 17;
        assertEquals(expected, actual);
    }
    public void testGetShortestRoute() {// сделать метод
        List<Station> actualOneTheLine = calculator.getShortestRoute(st1l3, st3l3);
        List<Station> actualOneConnection = calculator.getShortestRoute(st1l3, st2l2);
        List<Station> actualTwoConnection = calculator.getShortestRoute(st1l3, st2l5);

        List<Station> expectedOneTheLine = oneTheLine;
        List<Station> expectedOneConnection = oneConnection;
        List<Station> expectedTwoConnection = twoConnection;

        assertEquals(actualOneTheLine, expectedOneTheLine);
        assertEquals(actualOneConnection, expectedOneConnection);
       assertEquals(actualTwoConnection, expectedTwoConnection);
    }

}
