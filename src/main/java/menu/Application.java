package menu;

import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printStart();
        System.out.println(InputView.getCoaches());
    }
}
