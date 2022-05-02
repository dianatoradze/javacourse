import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {
    List<Station> oneTheLine;
    List<Station> oneConnection;
    List<Station> twoConnection;
    StationIndex stationIndex;
    RouteCalculator calculator;

    Station st1l3;

    Station st2l2;

    Station st2l5;
    Station st3l3;
    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        Line line5 = new Line(3, "Пятая");
//      добавление линии

        st1l3 = new Station("Приморская", line3);
        Station st2l3 = new Station("Василеостровская", line3);
        st3l3 = new Station("Гостиный двор", line3);

//      добавление станции на линии

        Station st1l2 = new Station("Невский проспект", line2);
        st2l2 = new Station("Сенная площадь", line2);

        Station st1l5 = new Station("Садовая", line5);
        st2l5 = new Station("Звенигородская", line5); // проверить пересадки

        Stream.of(line2, line3, line5).forEach(stationIndex::addLine);
        Stream.of(st1l3, st2l3, st3l3, st1l2,st2l2, st1l5, st2l5)
                .peek(s -> s.getLine().addStation(s)).forEach(stationIndex::addStation);
//        stationIndex.addConnection(Stream.of(st3l3, st1l2).collect(Collectors.toList()));
//        stationIndex.addConnection(Stream.of(st2l2, st1l5).collect(Collectors.toList()));
//
//        stationIndex.getConnectedStations(st3l3); //проверить линии Сенная-Садовая
//        stationIndex.getConnectedStations(st2l2);
//
//        calculator = new RouteCalculator(stationIndex);

        List<Station> cs1 = new ArrayList<>();
        cs1.add(stationIndex.getStation(st3l3.getName(), st3l3.getLine().getNumber()));
        cs1.add(stationIndex.getStation(st1l2.getName(), st1l2.getLine().getNumber()));
        List<Station> cs2 = new ArrayList<>();
        cs2.add(stationIndex.getStation(st2l2.getName(), st2l2.getLine().getNumber()));
        cs2.add(stationIndex.getStation(st2l5.getName(), st2l5.getLine().getNumber()));
        //добавляем соединнения в обобщенный клас
        stationIndex.addConnection(cs1);
        stationIndex.addConnection(cs2);
        //создаем экземпляр класса расчета маршрута с нашим собранным обобщеным классом
        calculator = new RouteCalculator(stationIndex);

        //тестовые маршруты
        oneTheLine = Stream.of(st1l3, st2l3, st3l3).collect(Collectors.toList());
        oneConnection = Stream.of(st1l3, st2l3, st3l3, st1l2, st2l2)
                .collect(Collectors.toList());
        twoConnection = Stream
                .of(st1l3, st2l3, st3l3, st1l2, st2l2,st1l5, st2l5)
                .collect(Collectors.toList());

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(oneTheLine);
        double expected = 5;
        assertEquals(expected, actual);
    }
    public void testCalculateConnection() {
        double actual = RouteCalculator.calculateDuration(oneConnection);
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {// сделать метод
        List<Station> actualOneTheLine = calculator.getShortestRoute(st1l3, st3l3);
        List<Station> actualOneConnection = calculator.getShortestRoute(st1l3, st2l2);
        //List<Station> actualTwoConnection = calculator.getShortestRoute(st1l3, st2l5);

        List<Station> expectedOneTheLine = oneTheLine;
        List<Station> expectedOneConnection = oneConnection;
       // List<Station> expectedTwoConnection = twoConnection;
        List<Station> route = calculator.getShortestRoute(stationIndex.getStation("Приморская"), stationIndex.getStation("Звенигородская"));

        assertEquals(actualOneTheLine, expectedOneTheLine);
        assertEquals(actualOneConnection, expectedOneConnection);
        //assertEquals(actualTwoConnection, expectedTwoConnection);
    }

}
