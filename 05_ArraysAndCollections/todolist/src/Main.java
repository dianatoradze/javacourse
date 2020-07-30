import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите команду цифрой. 1- ADD- добавить дело. 2-LIST - вывод списка." +
                "5- EXIT - выход из программы " + "3-EDIT — заменить дело; " + "4-DELETE — удалить");

        Scanner deal = new Scanner(System.in);

        int deleteNumber = 0;
        String choice;
        int count=0;
        String dealEdit;
        String item;

        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("delo pervoe");
        todoList.add("delo vtoroe");
        System.out.print("Введите  команду: ");
        Scanner dealItem = new Scanner(System.in);

        while (deal.hasNext()) {

            choice = deal.nextLine();
            switch (choice) {
                case "ADD":
                    System.out.println("Введите дело в список ");
                    for (int i = 0; i < todoList.size(); i++) {
                        ;
                        item = dealItem.nextLine();
                        if (!item.isEmpty()) {
                            todoList.add(item);
                            if (item.equals("stop")) {
                                break;
                            }
                            count++;
                        } else {
                            i--;
                        }
                    }
            break;
                case  "LIST":
                for (String s1 : todoList) {
                  if (!s1.equals("stop")) {
                     System.out.println("Ваш список дел: " + s1 + " номер " + todoList.indexOf(s1));
                    }
                }
                break;
                case  "EDIT":
                System.out.println("Введите, новое дело вместо старого");
                for (String s2 : todoList) {
                    dealEdit = deal.nextLine();
                    todoList.set(0, dealEdit);
                }
                break;
                case  "DELETE":
                for (String s3 : todoList) {
                    System.out.println("Введите номер дела, которе нужно удалить");
                    deleteNumber = deal.nextInt();
                    todoList.remove(deleteNumber);
                }
            break;
               case "EXIT":
                   deal.close();
                 break;
        }
     }
 }
}
