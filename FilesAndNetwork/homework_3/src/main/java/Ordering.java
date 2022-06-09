public class Ordering {

    public String income;
    public String expense;
    public String account;
    public String number;
    public String value;
    public String data;
    public String description;
    public String count;
    public Ordering(String pathMovementsCsv) {
    }

//    public double getExpenseSum() {
//        return 0.0;
//    }
//
//    public double getIncomeSum() {
//        return 0.0;
//    }


    @Override
    public String toString() {
        return
                "\nincome=" + income +
                ", \nexpense=" + expense +
                ", \ncount='" + count +
                '}';
    }
}
