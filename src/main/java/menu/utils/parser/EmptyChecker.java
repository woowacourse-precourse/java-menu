package menu.utils.parser;

public class EmptyChecker {
    private EmptyChecker() {
    }

    public static void check(final String input) {
        if (isEmptyOrNull(input)) {
            throw new IllegalArgumentException("비어있습니다");
        }
    }

    private static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }
}
