public class Operator implements Employee {
    private final int salary = (int) ((Math.random() * 20000) + 20000);



    @Override
    public int getMonthSalary() {
        return salary;
    }
}
