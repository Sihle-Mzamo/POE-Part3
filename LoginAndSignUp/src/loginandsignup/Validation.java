package loginandsignup;




import java.util.regex.Pattern;

/**
 *
 * @author Sihle Mzamo
 */
public class Validation {
    public static boolean isValidUsername(String username) {
        return username.length() >= 5 && username.contains("_");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String cleaned = phoneNumber.replaceAll("\\s+", "");
        if (!cleaned.startsWith("+27") || cleaned.length() != 12) return false;
        String localNum = cleaned.substring(3);
        return localNum.matches("[678]\\d{8}");
    }

    public static boolean isValidPassword(String password) {
    if (password.length() < 8) return false;

    boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
    boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
    boolean hasSpecialChar = Pattern.compile("[!@#$%^&()_+=<>?/{}]").matcher(password).find();

    return hasUppercase && hasDigit && hasSpecialChar;
}
    
}
