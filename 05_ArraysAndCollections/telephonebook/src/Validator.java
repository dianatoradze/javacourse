import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Pattern pattern;
    public static Matcher matcher;


    private static final String PHONE_PATTERN =
            "(?:\\+\\d)?\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2}";
    private static  final String NAME_PATTERN = "([А-ЯЁ][а-яё]*-?([А-ЯЁ]?[а-яё]+))";

    public  static boolean validateName(final String name){
        pattern = Pattern.compile(NAME_PATTERN,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public  static boolean validatePhone(final String phoneNumber){
        pattern = Pattern.compile(PHONE_PATTERN,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
    class ItemShablon {

        {
            Label validItemName = new Label();
            boolean b = Validator.validateName(validItemName.getText());
            Label validPhone = new Label();
            boolean c = Validator.validatePhone(validPhone.getText());
        }

        public ItemShablon(String phoneNumber) {
            
        }
    }