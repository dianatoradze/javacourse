import java.util.*;

public class Generated {


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.addAll(CarNumber.numbersGemerator());
         Collections.sort(list);
         System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);
            while (scanner.hasNext()) {
        System.out.println("Введите номер для поиска");
        String number = scanner.nextLine();
        System.out.println(list);
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

