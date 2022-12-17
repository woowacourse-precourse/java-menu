package menu;

import java.util.function.Function;
import java.util.function.Supplier;
import menu.view.OutputView;

public interface ReadUntilValidTemplate {
    public static <T, R> R read(Function<T, R> object, Supplier<T> input) {
        while (true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
