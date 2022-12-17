package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuMaker {
    private final Coach coach;
    private final List<Category> categories;

    public MenuMaker(Coach coach, List<Category> categories) {
        this.coach = coach;
        this.categories = categories;
    }

    public List<Menu> makeRandomMenus() {
        List<Menu> coachMenu = new ArrayList<>();
        for(Category category : categories) {
            List<String> menus = category.getMenuList()
                    .stream()
                    .map(Menu::getMenuName)
                    .collect(Collectors.toList());
            Menu randomMenu = makeRandomMenu(menus);
        }
        return coachMenu;
    }

    public Menu makeRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return new Menu(menu);
    }
}
