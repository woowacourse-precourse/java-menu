package menu;

import java.util.List;
import menu.cofig.InitMenu;
import menu.controller.MenuController;
import menu.domain.CategoryMenu;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<CategoryMenu> categories = InitMenu.categoryMenus();
        MenuController controller = new MenuController(categories);
        controller.start();
    }
}
