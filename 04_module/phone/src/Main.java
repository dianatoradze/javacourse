import java.util.Scanner;

public class Main {
    public static void main (String[] args)
    {
    //  +7 909 123-45-67
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер телефона");
        String phone = in.nextLine();
        System.out.println(phone.replaceAll("[+]?(8|7)[-]?\\s+?\\(?(\\d{3})\\)[-]?\\s+?(\\d{3})[-]?(\\d{2})[-]?(\\d{2})", "+$1 $2 $3-$4-$5"));
    }
}
