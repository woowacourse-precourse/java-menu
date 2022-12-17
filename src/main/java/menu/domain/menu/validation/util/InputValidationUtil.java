package menu.domain.menu.validation.util;

public class InputValidationUtil {

    public static boolean validateLength(final int startInclusive, final int endInclusive, String target) {
        return target.length() >= startInclusive && target.length() <= endInclusive;
    }
}
