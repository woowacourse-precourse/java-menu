package menu.util;

import java.util.function.Supplier;

public class RepeatValidator {

    public static <T> T readUntilValidate(Supplier<T> expression) {
        T input = null;
        do {
            input = tryExpression(expression);
        } while (input == null);

        return input;
    }

    private static <T> T tryExpression(Supplier<T> expression) {
        try {
            return expression.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}