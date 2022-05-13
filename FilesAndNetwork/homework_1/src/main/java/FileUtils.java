import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private static long sizeFolder;

    public static long calculateFolderSize(String path)  {

        Path folder = Paths.get(path);
        try {
            sizeFolder = Files.walk(folder)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sizeFolder;
    }
}