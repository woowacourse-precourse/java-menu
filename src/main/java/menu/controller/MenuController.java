package menu.controller;

import menu.model.CoachGroup;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        outputView.printInit();
        input(CoachGroup::new, inputView::inputCoachName);

    }

    public <T, R> R input(Function<T, R> function, Supplier<T> supplier) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.printErrorMessage(e);
            return input(function, supplier);
        }
    }
}
