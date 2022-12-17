package menu;

import menu.controller.Controller;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(initInputView(), initOutputView());
        controller.run();
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
