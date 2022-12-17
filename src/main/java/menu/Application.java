package menu;

import menu.controller.LunchMenuMachine;
import menu.domain.MenuMaker;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        MenuMaker menuMaker = new MenuMaker(inputView, new OutputView());

        LunchMenuMachine lunchMenuMachine = new LunchMenuMachine(inputView, new OutputView(), menuMaker);
        lunchMenuMachine.run();
    }
}

