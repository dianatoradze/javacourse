public class TopManager implements Employee {
    private  int salary = (int) ((Math.random() * 50000)+50000);
    private Company company;

    public TopManager(Company company) {

        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 100000) {
            return (int) (salary + salary * 1.5);
        }
        return salary;

    }
}
