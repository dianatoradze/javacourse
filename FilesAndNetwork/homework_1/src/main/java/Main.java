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

                double size = FileUtils.calculateFolderSize(String.valueOf(file));
                if (file.exists()) {
                    File dir = new File(file.getPath());
                    print(size, dir);
                } else {
                    System.out.println("Файл отсутствует");
                    continue;
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(double size, File dir) {
        StringBuffer sb = new StringBuffer();

        sb.append("Размер папки ").append(dir).append(", составляет ");

        if (size > GIGABYTE) {
           sb.append(String.format("%.1f", size / GIGABYTE )).append(" гигабайт");
        } else if (size > MEGABYTE) {
            sb.append(String.format("%.1f", size / MEGABYTE)).append(" мегабайт");
        } else if (size > KILOBYTE) {
            sb.append(String.format("%.1f", size / KILOBYTE)).append(" килобайт");
        } else {
            System.out.print(size);
        }
        System.out.print(sb);
    }

}

