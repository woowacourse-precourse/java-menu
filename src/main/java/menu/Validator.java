package menu;

import java.util.function.Supplier;

public class Validator {
    public static <T>T repeatUntilValid(Supplier<T> readInput) {
        try {
            return readInput.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(readInput);
        }
    }

}
