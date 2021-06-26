import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) throws ParseException {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) throws ParseException {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Date date1 = (new SimpleDateFormat("dd.MM.yyyy")).parse("01.01.2017");
        Date date2 = (new SimpleDateFormat("dd.MM.yyyy")).parse("31.12.2017");

        Employee employee = staff.stream().filter(e -> e.getWorkStart().after(date1) && e.getWorkStart().before(date2))
                .max(Comparator.comparing(Employee::getSalary)).get();
        return employee;

    }
}