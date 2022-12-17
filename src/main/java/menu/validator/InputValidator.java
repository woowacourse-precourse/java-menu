package menu.validator;

public class InputValidator {
    private static final int minNameLength = 2;
    private static final int maxNameLength = 4;
    private static final int minCoachCount = 2;
    private static final int maxCoachCount = 5;

    public static boolean isValidNameInput(String namesInput) {
        if (isContainingSpace(namesInput) || !isValidLengthNames(namesInput) || !isValidCoachCount(namesInput)) {
            return false;
        }
        return true;
    }

    private static boolean isContainingSpace(String namesInput) {
        return namesInput.contains(" ");
    }

    private static boolean isValidLengthNames(String namesInput) {
        String[] names = namesInput.split(",");
        for (String name : names) {
            if (name.length() < minNameLength || name.length() > maxNameLength) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCoachCount(String namesInput) {
        String[] coaches = namesInput.split(",");
        if (coaches.length < minCoachCount || coaches.length > maxCoachCount) {
            return false;
        }
        return true;
    }
}
