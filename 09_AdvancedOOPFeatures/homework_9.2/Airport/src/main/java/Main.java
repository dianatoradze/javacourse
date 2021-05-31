import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.skillbox.airport.Flight.Type.valueOf;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
//                    terminal.addFlight(this.generateFlight(Type.DEPARTURE));
        airport.getAllAircrafts().stream().flatMap((Aircraft t) -> Flight.getDate(t))
                .stream().forEach(e-> {
            //return System.out.println(valueOf(String.valueOf(Type.DEPARTURE)));

        });

        //airport.getAllAircrafts().stream().map(DEPARTURE))
.collect(Collectors.groupingBy(Type.DEPARTURE));


                        //toList().forEach(System.out::println);

        return Collections.list();
                //Collections.emptyList();
    }

}