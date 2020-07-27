import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите команду. ADD- добавить дело. LIST - вывод списка." +
                " EXIT - выход из программы ");

        Scanner deal = new Scanner(System.in);
        String x0=deal.nextLine();;
        String x1 = "ADD";
        String x2 = "LIST";
        String x3 = "EXIT";


        ArrayList<String> mailList = new ArrayList<>();
        TreeSet<String> adress = new TreeSet<>();
        for (int i=0; i<mailList.size();i++) {

            String s = deal.nextLine();
            if (s.equals(x3)) {
                break;
            }
            if (x0.equals(x1)) {

                System.out.print("Введите адрес которое хотите добавить в список : ");
                x1 = deal.nextLine();
                mailList.add(x1);
                System.out.println(i + "Новое дело добавленно в список! \n" + mailList.get(i));
            }
            if (x0.equals(x2)) {
                x2 = deal.nextLine();
                // вывод списка
                for (String item : mailList) {
                    System.out.println(item);
                }
            }

        }
        //System.out.println(MailList.contains("Адрес")); вывод потока
    }
}
