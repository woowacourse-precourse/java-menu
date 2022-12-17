package menu.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;
import menu.domain.MenuService;
import menu.view.OutputView;

public class Controller {
    private final MenuService menuService = new MenuService();

    public void run() {

    }

    public <T> void repeat(Supplier<T> reader, Consumer<T> initializer) {
        try {
            initializer.accept(reader.get());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            repeat(reader, initializer);
        }
    }
}
