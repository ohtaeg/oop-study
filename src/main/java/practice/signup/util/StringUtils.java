package practice.signup.util;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(final String value) {
        if (value == null || value.trim().equals("")) {
            return true;
        }
        return false;
    }
}
