import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {
    private static final long GIGABYTE = 1073741824;
    private static final long MEGABYTE = 1048576;
    private static final long KILOBYTE = 1024;
    private static InputStreamReader path;

    public static void main(String[] args) {
        // C:\Users\diana\Documents

            path = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(path);

            for (; ; ) {
                try {
                    System.out.println("Введите путь до папки:");
                    File file = new File(reader.readLine());

                    if (file.exists()) {
                        FileUtils.calculateFolderSize(String.valueOf(file));

                    } else {
                        System.out.println("Файл отсутствует");
                        continue;
                    }
                    print();
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private static void print () {
            double size = FileUtils.calculateFolderSize(String.valueOf(path));
            if (size > GIGABYTE) {
                System.out.printf("Размер папки ", path, " составляет ", size / GIGABYTE,
                        " гигабайтов");
            } else if (size > MEGABYTE) {
                System.out.printf("Размер папки ", path, " составляет ", size / MEGABYTE,
                        " мегабайтов");
            } else if (size > KILOBYTE) {
                System.out.printf("Размер папки ", path, " составляет ", size / KILOBYTE,
                        " килобайтов");
            } else {
                System.out.printf("Размер папки ", path, " составляет ", size);
            }
        }
    }

