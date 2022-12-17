package menu.domain.draw;

import menu.domain.category.Category;
import menu.domain.factory.MenuCreator;
import menu.domain.menu.Menu;

public class MenuDraw {
    public static Menu menuDraw(Category category) {
        return MenuCreator.from(category).get(0);
    }
}
