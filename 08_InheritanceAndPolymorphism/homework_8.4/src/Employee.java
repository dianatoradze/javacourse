import java.util.ArrayList;
import java.util.List;

public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(),o.getMonthSalary());
    }

}
