package menu.controller.exception;

import java.util.function.Supplier;
import menu.view.OutputView;

public class Exception {
    public static <T> T exceptionError(final Supplier<T> value) {
        try {
            return value.get();
        } catch (final IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return exceptionError(value);
        }
    }
}
