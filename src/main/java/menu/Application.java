package menu;

import java.util.List;
import menu.cofig.InitMenu;
import menu.controller.MenuController;
import menu.domain.Category;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Category> categories = InitMenu.categories();
        MenuController controller = new MenuController(categories);
        controller.start();
    }
}
