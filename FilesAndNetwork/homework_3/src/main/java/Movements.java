import java.util.HashMap;
import java.util.Map;

public class Movements {
    private String pathMovementsCsv;
    private double income = 0;
    private double expense = 0;
    private final Map<String, Double> resultExpences = new HashMap<>();

    public Movements(String pathMovementsCsv) {

        this.pathMovementsCsv = pathMovementsCsv;
    }

    public void getIncomeSum(String path) {

        String[] source = path.split(",", 8);
        double incomeSplit = Double.parseDouble(source[6]);
        double expenseSplit = Double.parseDouble(source[7].replaceAll("\"", "").replace(',', '.'));
        if (incomeSplit == 0) getExpenseSum(source[5], expenseSplit);
        this.income += incomeSplit;
    }

    public void getExpenseSum(String expenseParties, double expense) {
        this.expense += expense;

        String[] item = expenseParties.trim().split(" {3,}");
        String[] values = item[1].split("/");
        String[] expenseItem = values[values.length - 1].split("\\\\");
        String amount = expenseItem[expenseItem.length - 1];

        if (!resultExpences.containsKey(amount))
            resultExpences.put(amount, expense);
        else {
            double sum = resultExpences.get(amount);
            sum += expense;
            resultExpences.put(amount.trim(), sum);
        }
    }

    public void print() {
        System.out.printf("Сумма расходов: %.2f руб.\n", expense);
        System.out.printf("Сумма доходов: %.2f руб.\n", income);
        System.out.println();
        System.out.println("Сумма расходов по организациям:");
        for (String supplies : resultExpences.keySet()) {
            System.out.printf("%-10s  %.2f %-10s\n", supplies, resultExpences.get(supplies), "руб.");
        }

    }
}
