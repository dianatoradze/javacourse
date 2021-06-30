import java.text.ParseException;
import java.time.ZoneId;
import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) throws ParseException {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);

    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) throws ParseException {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        Employee employee = staff.stream()
                .filter( e-> e.getWorkStart().toInstant().atZone(ZoneId.systemDefault()).getYear() == year)
                .max(Comparator.comparing(Employee::getSalary)).get();
        return employee;

    }
}