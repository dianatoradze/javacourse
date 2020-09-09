import java.util.*;

import static java.lang.String.valueOf;

class CarNumber {
    private static void print(ArrayList<String> list) {
        Iterator<String> it = numbersGemerator().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static List<String> numbersGemerator() {
        int regionCode = 1;
       final  String[] NUMBER_CHARS = new String[]{"C", "M", "T", "B", "A", "P", "O", "H", "E", "У"};

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
