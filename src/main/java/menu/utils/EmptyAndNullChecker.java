package menu.utils;

public class EmptyAndNullChecker {

    public static void check(final String input) {
        try {
            if (input.isBlank()) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

}
