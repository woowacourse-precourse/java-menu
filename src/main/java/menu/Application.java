package menu;

import menu.ui.InputView;
import menu.ui.OutputView;

public class Application {
    static MenuService menuService=new MenuService();
    public static void main(String[] args) {
        menuService.startService();

    }
}
