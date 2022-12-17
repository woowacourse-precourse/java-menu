package menu.controller;

import menu.service.MainService;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        outputView.printStart();
        List<String> coachNames = repeat(inputView::readNames);
        mainService.generateCoaches(coachNames);
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
