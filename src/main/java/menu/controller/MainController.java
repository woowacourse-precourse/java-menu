package menu.controller;

import java.util.function.Supplier;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RecommendService recommendService = new RecommendService();

    public <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }


}
