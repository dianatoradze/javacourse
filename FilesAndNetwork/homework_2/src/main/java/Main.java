import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static InputStreamReader path;
    public static void main(String[] args) {
        //C:\Users\diana\Documents\Java\Коды
        path = new InputStreamReader(System.in);

        BufferedReader reader = new BufferedReader(path);

        for (; ; ) {
            System.out.println("Введите путь к папке которую хотите скопировать:");
            File sourceFile = null;
            try {
                sourceFile = new File(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!sourceFile.exists()) {
                System.out.println("Файл отсутствует!");
                continue;
            }
            System.out.println("Введите путь:");
            File destinationFile = null;
            try {
                destinationFile = new File(reader.readLine() + File.separator + sourceFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!destinationFile.exists()) destinationFile.mkdirs();

            FileUtils.copyFolder(String.valueOf(sourceFile),String.valueOf(destinationFile));
        }
    }
}
