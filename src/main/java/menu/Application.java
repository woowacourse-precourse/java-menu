package menu;

import menu.controller.LunchMenuMachine;
import menu.domain.MenuMaker;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 인풋뷰 생성자 안에 검증 클래스 넣기.
        InputView inputView = new InputView();

        MenuMaker menuMaker = new MenuMaker(inputView);

        LunchMenuMachine lunchMenuMachine = new LunchMenuMachine(inputView, new OutputView(), menuMaker);
        lunchMenuMachine.run();

    }
}

