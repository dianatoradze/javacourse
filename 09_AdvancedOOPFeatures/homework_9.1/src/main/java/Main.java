import java.util.*;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
        for (Employee employee: staff) {
            System.out.println(employee);
        }

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        //Collections.sort(staff, (o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
        staff.sort((o1, o2) -> {

            sortByAlphabet(staff, o1, o2);

            return o1.getSalary().compareTo(o2.getSalary());

        });
    }

    private static void sortByAlphabet(List<Employee> staff, Employee o1, Employee o2) {
        if (o1.getSalary().equals(o2.getSalary())) {

            Collections.sort(staff, Comparator.comparing(Employee::getName));

        }
//        else {
//            Collections.sort(staff, Comparator.comparingInt(Employee::getSalary));
//        }
    }
}

