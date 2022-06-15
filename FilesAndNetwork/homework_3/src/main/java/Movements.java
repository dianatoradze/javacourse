import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {

    private double income;
    private double expense;
    private double sumIncome;
    private double sumExpense;
    private final Map<String, Double> resultExpences = new HashMap<>();
    String[] values;

    public Movements(String pathMovementsCsv) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(pathMovementsCsv));

            for (int i = 1; i < lines.size(); i++) {

                values = lines.get(i).split(",", 8);

                income = Double.parseDouble(values[6]);
                sumIncome += income;
                expense = Double.parseDouble(values[7].replaceAll("\"", "").replace(',', '.'));
                sumExpense += expense;
                setIncome(values);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getIncomeSum() {

        setIncome(values);

        return sumIncome;

    }

    public double getExpenseSum() {
        this.expense += expense;

        return sumExpense;
    }

    private void setIncome(String[] values) {
        if (income == 0) {
            String parts = values[5];
            split(parts, expense);
        } else this.income += income;
    }

    private void split(String parties, double expenseSplit) {
        String[] item = parties.trim().split(" {3,}");
        String[] value = item[1].split("/");
        String[] expenseItem = value[value.length - 1].split("\\\\");
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
        System.out.printf("Сумма расходов: %.2f руб.\n", getExpenseSum());

        System.out.printf("Сумма доходов: %.2f руб.\n", getIncomeSum());
        System.out.println();
        System.out.println("Сумма расходов по организациям:");
        for (String parts : resultExpences.keySet()) {
            System.out.printf("%-10s  %.2f %-10s\n", parts, resultExpences.get(parts), "руб.");
        }

    }
}
