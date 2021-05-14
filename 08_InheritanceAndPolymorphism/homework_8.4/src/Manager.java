public class Manager implements Employee {
    private int salary = (int) ((Math.random() * 30000)+30000);
    private int sales;

    public Manager() {

        sales = (int) (Math.random() * (140000 - 115000) + 115000);
    }

    public int getSales() {
        return sales;
    }

    @Override
    public int getMonthSalary() {
        return ((int) (salary+sales * 0.05));
    }
}
