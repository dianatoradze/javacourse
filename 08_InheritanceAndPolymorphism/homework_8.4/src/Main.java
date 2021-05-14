import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        TopManager topManager = new TopManager(company);
        System.out.println("Зарплата " + topManager.getMonthSalary());
        List<Employee> jobs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            company.hire(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            jobs.add(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            jobs.add(new TopManager(company));

        }
        company.hireAll(jobs);

        System.out.println("Доход компании " + company.getIncome());
        print(company);
        List<Employee> employees = company.getEmployees();
        System.out.println("Размер компании " + employees.size());
        for (int i = 0; i < (employees.size()) / 2; i++) {
            company.fire(employees.get(i));
        }
        System.out.println("После увольнения " + company.getEmployees().size());

        print(company);
    }

    private static void print(Company company) {
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);
        System.out.println("Самые высокие зарплаты");
        for (Employee workers : topSalaryStaff) {
            System.out.println(workers.getMonthSalary());
        }
        List<Employee> lowSalaryStaff = company.getLowestSalaryStaff(30);
        System.out.println("Самые низкие зарплаты");
        for (Employee workers : lowSalaryStaff) {
            System.out.println(workers.getMonthSalary());
        }
    }
}
