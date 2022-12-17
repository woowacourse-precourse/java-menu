package menu.util;

import java.util.function.Supplier;
import menu.view.OutputView;

public class Retry {
    
    private static final OutputView outputView = new OutputView();

    public static <T> T execute(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return execute(supplier);
        }
    }

    public static void execute(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            execute(runnable);
        }
    }
}
