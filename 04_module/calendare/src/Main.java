import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Calendar c2 = Calendar.getInstance();
        Date dr = new Date;
        c2.setTime(dr); // Дата рождения
        c2.set(Calendar.YEAR, 2016);          // год который вам нужен

        System.out.println(c2.getTime());     // результат для того что бы добавить 18 лет

        Calendar c = Calendar.getInstance();
        c.setTime(dr); // Дата рождения
        c.add(Calendar.YEAR, 18);    // добавляем 18 лет

        System.out.println(c.getTime());     // результат
    }
}