import javax.swing.text.html.ListView;
import java.util.*;

public class Generated {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();
        list.addAll(numbersGemerator());
        Collections.sort(list);
            Scanner scanner = new Scanner(System.in);

           HashSet<String> hashSet  = new HashSet<>(list);
//        List <String> numbers=List.copyOf(list);
//        HashSet<String> numbersHashSet = new HashSet<>(numbers);

           TreeSet<String> treeSet = new TreeSet<>();
           treeSet.addAll(list);

            while (scanner.hasNext()) {

                System.out.println("Введите номер для поиска");
                String number = scanner.nextLine();

                long start = System.nanoTime();
                long resultTime = 0;
                if (list.contains(number)) {
                    resultTime = System.nanoTime() - start;
                    System.out.println("Поиск перебором: номер найден, поиск занял: " + resultTime + " нс");
                } else {
                    System.out.println("Поиск перебором: номер не найден, поиск занял: " + resultTime + " нс");
                }
                long b = System.nanoTime();

                int search = Collections.binarySearch(list, number);

                if (search >= 0) {
                    resultTime = System.nanoTime() - b;
                    System.out.println("Бинарный поиск: номер найден, поиск занял: " + resultTime + " нс");
                } else {
                    System.out.println("Бинарный поиск: номер не найден, поиск занял: " + resultTime + " нс");
                }
                long c = System.nanoTime();
               ;
                if (hashSet.contains(number)) {
                    resultTime = System.nanoTime() - c;
                    System.out.println("Поиск в HashSet: номер найден, поиск занял: " + resultTime + " нс");
                } else {
                    System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + resultTime + " нс");
                }
                long d = System.nanoTime();

                if (treeSet.contains(number)) {
                    resultTime = System.nanoTime() - d;
                    System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + resultTime + " нс");
                } else {
                    System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + resultTime + " нс");
                }
            }
        }

        public static ArrayList <String> numbersGemerator() {

            int regionCode = 1;
            ArrayList<String> result = new ArrayList<>();
            final  String[] NUMBER_CHARS = new String[]{"C", "M", "T", "B", "A", "P", "O", "H", "E", "У"};

            while (regionCode < 200) {
                for (String x : NUMBER_CHARS) {
                    for (String y : NUMBER_CHARS) {
                        for (String z : NUMBER_CHARS) {
                            for (int j = 1; j < 100; j++) {
                                if (regionCode < 100) {
                                    result.add(String.format("%s%03d%s%s%02d", x, j, y, z, regionCode));
                                } else {
                                    result.add(String.format("%s%03d%s%s%03d", x, j, y, z, regionCode));
                                }
                            }
                        }
                    }
                }
                regionCode++;
            }
            return result;
        }
    }









