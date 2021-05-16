import java.util.*;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    //   получение значения дохода компании –
    public int getIncome() {
        int income = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getSales();
            }
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getListEmployee(count, Comparator.comparingInt(Employee::getMonthSalary).reversed());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getListEmployee(count, Employee::compareTo);
    }

    private List<Employee> getListEmployee(int count, Comparator <Employee> comparator) {
        if (count < 0) {
            System.out.println("Неверное значение");
            return Collections.emptyList();
        }
        if (count > employees.size()) {
            count = employees.size();
        }
        employees.sort(comparator);
        List<Employee> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(employees.get(i));
            }
            return result;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
