
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoriesFile {
    private static String path = "C:/Users/diana/Documents/Java/Проекты/homework_5/data";
    private static String pathFile = "src/main/resources/stations.json";

    public static void main(String[] args) {

        try {

            String[] extensions1 = {"json"};

            List filesJson = findFiles(Paths.get(path), extensions1);


            filesJson.forEach(x -> {
                System.out.println(nameFile(Collections.singletonList(x)));
            });

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String nameFile(List filesJson) {
        String name = new File(String.valueOf(filesJson)).getName();

        int idx = name.replaceAll("\\\\", "").lastIndexOf("/");
        return idx >= 0 ? name.substring(idx + 1) : name;
    }

    public static List findFiles(Path path, String[] fileExtensions) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List result;
        try (Stream walk = Files.walk(path)) {
            result = (List) walk
                    .filter(p -> !Files.isDirectory((Path) p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> isEndWith(String.valueOf(f), fileExtensions))
                    .collect(Collectors.toList());
        }
        return result;

    }

    private static boolean isEndWith(String file, String[] fileExtensions) {
        boolean result = false;
        for (String fileExtension : fileExtensions) {
            if (file.endsWith(fileExtension)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
