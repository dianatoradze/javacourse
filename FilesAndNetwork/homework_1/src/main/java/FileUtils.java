import java.io.File;
import java.util.Objects;

public class FileUtils {
    private static long sizeFiles;

    public static long calculateFolderSize(String path) {

//        try {
//            List<String> files = Files.readAllLines(Paths.get(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File file = new File(path);
        if (file.isDirectory()) {
            for (File file1 : Objects.requireNonNull(file.listFiles())) {
                String s = String.valueOf(file1);
                calculateFolderSize(s);
            }
        } else {
            sizeFiles += file.length();
        }

        return sizeFiles;
    }

}
