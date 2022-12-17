package menu;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MenuController {
    private Menu menu = new Menu();
    private Coach coach;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runProgram() {
        outputView.printStart();
        List<String> coachNames = repeat(inputView::readCoachNames);
        coach = new Coach(coachNames);
        try {
            List<String> disLikeFoods = inputView.readDislikeFoods(coachNames);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            List<String> disLikeFoods = inputView.readDislikeFoods(coachNames);
        }
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
