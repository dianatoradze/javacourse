import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> images = new ArrayList<>();
        Document document = Jsoup.connect("https://lenta.ru/").get();
        Elements img = document.select("img");
        // вывод url картинок
        System.out.println("Скачанные картинки");
        for (Element element : img) {
            String name = element.attr("abs:src");

            if (name.startsWith("https") && element.normalName().equals("img")) {
                images.add(name);

                System.out.println(element.attr("src"));
            }

            parser(images);

        }
    }


    public static void parser(List<String> images) {

        String pathCopy = "images" + "\\";

        for (String path : images) {
            try (InputStream in = new URL(path).openStream()) {

                Files.copy(in, Paths.get(pathCopy + new File(path).getName()), StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
