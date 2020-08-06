import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Anna", "0123456789");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command: ADD - find or enter contact, LIST - print contact ");
        while (scanner.hasNext()) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "ADD":
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter phone number");
                    String phoneNumber = scanner.next();
                    new checkNameNumber(name, phoneNumber);
                    if (phoneBook.containsKey(name) && phoneBook.containsValue(phoneNumber)) {
                    System.out.println("name " + name + "- number telephone "    + phoneNumber);
                     } else {
                        System.out.println("Add name");
                        String nameEdit = scanner.next();
                        new ItemShablon(nameEdit);
                        System.out.println("Add phone number");
                        String phoneEdit = scanner.next();
                        new ItemShablon(phoneEdit);
                        phoneBook.put(nameEdit, phoneEdit);
                        print(phoneBook);
                    }
                    break;
                case "LIST":
                    for (Map.Entry <String, String> digest:phoneBook.entrySet())
                     { //добавила, потому что выводится не весь список при добавлении нового контакта
                         if (Validator.matcher.matches()) {
                         System.out.println("Phone Number Valid");
                            System.out.println(digest.getKey() + " - " + digest.getValue());
                         }
                        else
                         {
                             System.out.println("Phone Number must be in the form");
                         }
                    }
                    break;
                case "EXIT":
                    scanner.close();
                    break;
            }
        }
    }

    private static void print(Map<String, String> map)
    {
        for(String key: map.keySet()) {
            System.out.println(key + " - " +  map.get(key));
        }
    }

    private static class checkNameNumber {
        public checkNameNumber(String name, String phoneNumber) {
            String regexName = "([А-ЯЁ][а-яё]*-?([А-ЯЁ]?[а-яё]+))";
            String regexPhoneNumber =   "((^\\+(\\D*\\d){11}$)|(^(\\D*\\d){10}$))";
            System.out.println(name+" - " + Pattern.matches(regexName, name));
            System.out.println(phoneNumber+" - " +Pattern.matches(regexPhoneNumber, phoneNumber));
        }
    }
}
