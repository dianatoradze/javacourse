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
        Collections.sort(employees);
        Collections.reverse(employees);
        return getListEmployee(count);
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        return getListEmployee(count);
    }

    private List<Employee> getListEmployee(int count) {
        if (count < 0 && count > employees.size()) {
            System.out.println("Неверное значение");
            return Collections.emptyList();
        }
       else {
            Collections.sort(employees);
        }
        return employees.subList(0, count);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
