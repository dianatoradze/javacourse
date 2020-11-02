import java.util.*;

public class Generated {

    private final static String[] NUMBER_CHARS = new String[]{"C", "M", "T", "B", "A", "P", "O", "H", "E", "У"};

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(numbersGemerator());
        Scanner scanner = new Scanner(System.in);

        HashSet<String> hashSet = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);

        while (scanner.hasNext()) {

            System.out.println("Введите номер для поиска");
            String number = scanner.nextLine();

            long a = System.nanoTime();
            if (list.contains(number)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            long b = System.nanoTime();
            int search = Collections.binarySearch(list, number);

            if (search >= 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            long c = System.nanoTime();
            if (hashSet.contains(number)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            long d = System.nanoTime();
            if (treeSet.contains(number)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            }
        }
    }

    private static Collection<? extends String> numbersGemerator() {

        int regionCode = 1;
        List<String> result = new ArrayList<>();
        while (regionCode < 200) {
            for (String x : NUMBER_CHARS) {
                for (String y : NUMBER_CHARS) {
                    for (String z : NUMBER_CHARS) {
                        for (int j = 1; j < 1000; j++) {
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











