package menu;

import menu.domain.CheckCoach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStartMessage();
        outputView.printNameRequestMessage();
        List<String> a = inputView.getNameList();




    }
}
