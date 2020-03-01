import java.util.Scanner;
// homework done
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова одной строкой через пробел");
        String surname = in.nextLine();

        int count = 0;
        if (surname.length() != 0) {
            count++;
            for (int i = 0; i < surname.length(); i++) {
                if (surname.charAt(i) == ' ') {
                    count++;
                }
            }
            if (count != 3) {
                System.out.println("Проверьте правильно ли введено ФИО");
            } else {
                int firstIndex = surname.indexOf(" ");
                int lastIndex = surname.lastIndexOf(" ");

                String firstName = surname.substring(0, firstIndex);
                String secondName = surname.substring(firstIndex + 1, lastIndex);
                String lastName = surname.substring(lastIndex + 1);

                System.out.println("Фамилия: " + firstName);
                System.out.println("Имя: " + secondName);
                System.out.println("Отчество: " + lastName);
            }
        }
    }
}
