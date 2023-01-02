package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class InputController {

    private final InputView inputView = new InputView();
    private final OutputView outputView;

    public InputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> inputCoachesName() {
        try {
            return inputView.readCoachesName();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return inputCoachesName();
        }
    }

    public List<String> inputHateFoods(String name) {
        try {
            return inputView.readHateFoods(name);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
            return inputHateFoods(name);
        }
    }
}
