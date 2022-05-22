import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static final String PATH = "files/movementList.csv";

    public static void main(String[] args) throws IOException {

        Movements bill = new Movements(PATH);
        List<String> lines;

        lines = Files.readAllLines(Paths.get(PATH));

        for (int i = 1; i < lines.size(); i++) {
            bill.getIncomeSum(lines.get(i));

        }
        bill.print();

    }
}
