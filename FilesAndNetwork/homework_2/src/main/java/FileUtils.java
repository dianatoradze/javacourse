import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
            try {
                Path directory1 = Paths.get(sourceDirectory);
                Path directory2 = Paths.get(destinationDirectory);

                List<Path> source = Files.walk(directory1).collect(toList());
                List<Path> destination = new ArrayList<>();
                for (Path path : source) {
                    Path relativize = directory1.relativize(path);
                    Path resolve = directory2.resolve(relativize);
                    destination.add(resolve);
                }

                for (int i = 0; i < source.size(); i++) {
                    Files.copy(source.get(i), destination.get(i), StandardCopyOption.REPLACE_EXISTING);
                }
                System.out.println("Файлы скопированы!");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
}
