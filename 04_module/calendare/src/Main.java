import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//homework
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy-EEEE");
        Calendar date = Calendar.getInstance();
        System.out.println(dateFormat.format(date.getTime()));

        GregorianCalendar calendar = new GregorianCalendar(1987, Calendar.JUNE , 17);

        System.out.println(0 + "-" + dateFormat.format(calendar.getTime()));

        for  (int i = 1; i <= 32; i++){
                calendar.roll( Calendar.YEAR,1);
                System.out.println(i + "-" + dateFormat.format(calendar.getTime()));
            }
        }
    }

