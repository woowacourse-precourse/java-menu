package menu.controller;

import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class Requester {
    private static final OutputView outputView = OutputView.getInstance();

    public static List<String> requestStringListInput(Supplier<List<String>> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return requestStringListInput(supplier);
        }
    }
}
