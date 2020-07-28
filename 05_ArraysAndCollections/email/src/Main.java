import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher m = pattern.matcher(EMAIL_PATTERN);
        boolean isEmail = m.matches();

        System.out.println("Введите команду. ADD- добавить дело. LIST - вывод списка." +
                " EXIT - выход из программы ");

        Scanner mail = new Scanner(System.in);
        String x0=mail.nextLine();;
        String x1 = "ADD";
        String x2 = "LIST";
        String x3 = "EXIT";


        ArrayList<String> mailList = new ArrayList<>();
        TreeSet<String> adress = new TreeSet<>();
     while (mail.hasNext()) {

            String s = mail.nextLine();
            if (s.equals(x3)) {
                break;
            }
            if (x0.equals(x1)) {

                System.out.print("Введите адрес которое хотите добавить в список : ");
                for (String adress1 : adress) {
                    adress1 = mail.nextLine();
                    if (isEmail=true) {
                        adress.add(x1);
                        System.out.println("Новое дело добавленно в список! " + adress1);
                    }
                    else System.out.println("Введите адрес по шаблону!" );
                }
            }
            if (x0.equals(x2)) {

                // вывод списка
                for (String adress2 : adress) {
                    adress2 = mail.nextLine();
                    System.out.println(adress2);
                }
            }

        }
        //System.out.println(MailList.contains("Адрес")); вывод потока
    }
}
