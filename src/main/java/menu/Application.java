package menu;

import menu.controller.RecommendMenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RecommendMenuController(new InputView(), new OutputView()).startRecommend();
    }
}
