import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String[]> list = new ArrayList<>();
        String[] array = new String[]{"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У", "Х", "К"};
        list.add(array);
//        HashSet <String> set = new HashSet<>(); добавление элементов list в set
//        set.addAll(list);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String number = scanner.next();

//            if (list.contains(number)) {
                //list.toArray(String[]::new);

                for (int i=0; i< array.length; i++) {

                    Arrays.sort(array);
                    System.out.println(Arrays.toString(array));
                }
//            }
        }


//    private static void getCarNumber (ArrayList<String> list) {
//        String item;
//               System.out.println("number item" + list.get(item));
//        for (int i=0; array.length; i++) {
//            //первые 2 нуля
//            for (String region:list.toArray(new String[0]))
//                for (String letterA:list.toArray(new String[0])) {
//                    System.out.printf("(%s%s)(%d%d%d)%s(%d%d)", item, letterA, item+letterA, region);
//                }
//
//            //буквы и цифры
//            for (int j = 111; j <= 999; j += 111) {
//                System.out.printf("(%s%s)(%d%d%d)%s(%d%d)", bukvy[i], j, bukvy[i] + bukvy[i], region);
//                for  (int k = 0; k < array.length; k++) {
//                    System.out.printf("%s%03d%s%02d\n", bukvy[j], i, bukvy[j2] + bukvy[k], region);
//                }
//            }
//        }
    }
}
