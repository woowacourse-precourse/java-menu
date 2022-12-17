package menu.util;

import menu.view.OutputView;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {
    private final OutputView outputView;

    public ExceptionHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }

    public <T> void process(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            process(consumer, t);
        } catch (IllegalStateException ex) {
            process(consumer, t);
        }
    }

    public <T> void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            run(runnable);
        }
    }
}
