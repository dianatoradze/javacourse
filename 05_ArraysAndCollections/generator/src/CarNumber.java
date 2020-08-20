import java.util.*;

import static java.lang.String.valueOf;

public class CarNumber {

    public static void main(String[] args) {

        String[] letters = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ;

            for (String s : letters) {

                for (int j = 0; j < 10; j++) {
                    for (int k = 1; k < 197; k++) {

                        String region = valueOf(k);

                        String carNumber = String.format("%s%d%d%d%s%s%s", s, j, j, j, s, s, region);
                        list.add(carNumber);
                        Collections.sort(list);

                       System.out.println(carNumber);

                    }
                }
            }
            HashSet<String> hashSet = new HashSet<>(list);
            TreeSet<String> treeSet = new TreeSet<>(list);

     while (true) {

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
}




