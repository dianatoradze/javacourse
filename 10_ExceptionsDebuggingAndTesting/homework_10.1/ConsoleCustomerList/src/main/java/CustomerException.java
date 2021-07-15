import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomerException extends Exception{
    public CustomerException(String message) {
        super(message);
    }

    public static boolean isPhoneNumberValid(String phone) {

        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean isEmailValid(String email) {

        String regexEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        Pattern p = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
