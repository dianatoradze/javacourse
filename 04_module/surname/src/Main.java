import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// homework done
public class Main {
    public static void main(String[] args) {
        final String REG_LAST_NAME = "([А-ЯЁ][а-яё]+[\\s|-]?([А-ЯЁ]?[а-яё]+))";
        final String REG_NAME = "([А-ЯЁ][а-яё]*-?([А-ЯЁ]?[а-яё]+))";
        final String REG_FULL_NAME = String.format("^%s %s %s$", REG_NAME, REG_NAME, REG_LAST_NAME);

        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова одной строкой через пробел");
        String surname = in.nextLine();
        Pattern paternFormat = Pattern.compile(surname);
        int count = 0;
        if (surname.length() != 0) {
            count++;
for (int i = 0; i < surname.length(); i++) {
   if (surname.charAt(i) == ' ') {
       count++;
     }
 }
            if (count != 3 && count != 4) {
                System.out.println("Проверьте правильно ли введено ФИО");
            }
                   else {
                String[] text = surname.split("\\s+");
                for (int i = 0; i < text.length; i++) {
                        count++;
                    Matcher m = paternFormat.matcher(text[i]);
                    surname= m.replaceAll(REG_FULL_NAME);
                       System.out.println(surname);

                }
            }
        }
    }
}
