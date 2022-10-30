
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoriesFile {
    private static String path = "C:/Users/diana/Documents/Java/Проекты/homework_5/data";
    private static String pathFile = "src/main/resources/stations.json";

    public static void main(String[] args) {

        try {

            String[] extensions1 = {"json","csv"};

            List filesJson = findFiles(Paths.get(path), extensions1);
            //List datesJson = loadDatesFromFile(path);
            filesJson.forEach(x -> System.out.println(x));
            //datesJson.forEach(System.out::println);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static List loadDatesFromFile(String path) {
        return getList(path);
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
    static List getList(String path) {
        List date = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] fragments = line.split("\t");

                String dateFormat = "dd.MM.yyyy";
                date.add((new SimpleDateFormat(dateFormat)).parse(fragments[1])
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
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
