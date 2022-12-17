package menu.controller;

import menu.service.MainService;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        outputView.printStart();
        List<String> coachNames = repeat(inputView::readNames);
        mainService.generateCoaches(coachNames);

        for (String coachName : coachNames) {
            process(this::setCantEatMenus, coachName);
        }
    }

    private void setCantEatMenus(String coachName) {
            outputView.printCoachCantEat(coachName);
            List<String> cantEatMenus = repeat(inputView::readCantEatMenu);
            mainService.setCantEatMenus(cantEatMenus);
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }

    private <T> void process(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            process(consumer, t);
        }
    }
}
