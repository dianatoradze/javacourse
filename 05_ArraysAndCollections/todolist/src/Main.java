import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите команду цифрой. 1- ADD- добавить дело. 2-LIST - вывод списка." +
                "3- EXIT - выход из программы " + "EDIT — заменить дело; " + "DELETE — удалить");

        Scanner deal = new Scanner(System.in);

        int deleteNumber = 0;
        int choice = 0;
        int count=0;
        String dealEdit;
        String item;

        ArrayList<String> todoList = new ArrayList<>();
        //int dealNumber = 1;
        todoList.add("delo pervoe");
        todoList.add("delo vtoroe");
        System.out.print("Введите цифру 1-5, соответствующей команде: ");
        Scanner dealItem = new Scanner(System.in);

        while (choice != 5) {
            choice = deal.nextInt();
            if (choice == 1) {

                System.out.println("Введите дело в список ");
              for (int i=0; i<todoList.size();i++){
                    ;
                    item = dealItem.nextLine();
                  if (!item.isEmpty()) {
                        todoList.add(item);
                        if (item.equals("stop")) {
                            break;
                        }
                        count++;} else {
                      i--;
                  }
                 }
               }
            else if (choice == 2) {
                for (String s1 : todoList) {
                    //item = s1;
                    if (!s1.equals("stop")) {
                        System.out.println("Ваш список дел: " + s1 + " номер " + todoList.indexOf(s1));
                    }
                }
            } else if (choice == 3) {
                System.out.println("Введите, новое дело вместо старого");
                for (String s2 : todoList) {
                    dealEdit = deal.nextLine();
                    todoList.set(0, dealEdit);
                }
            } else if (choice == 4) {
                for (String s3 : todoList) {
                    System.out.println("Введите номер дела, которе нужно удалить");
                    deleteNumber = deal.nextInt();
                    todoList.remove(deleteNumber);
                }
            } else {
                deal.close();
            }
        }
    }
}
