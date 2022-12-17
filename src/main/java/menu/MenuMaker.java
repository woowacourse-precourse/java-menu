package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.exception.MenuException;

public class MenuMaker {
    private final Coach coach;
    private final List<Category> categories;
    private final List<Menu> result;

    public MenuMaker(Coach coach, List<Category> categories) {
        this.coach = coach;
        this.categories = categories;
        this.result = new ArrayList<>();
    }

    public List<Menu> makeRandomMenus() {
        List<Menu> coachMenu = new ArrayList<>();
        for(Category category : categories) {
            List<String> menus = category.getMenuList()
                    .stream()
                    .map(Menu::getMenuName)
                    .collect(Collectors.toList());
            makeRandomMenu(menus);
        }
        return coachMenu;
    }

    private Menu makeRandomMenu(List<String> menus) {
        try {
            Menu menu = generateRandomMenu(menus);
            validateMenu(menu);
            return menu;
        } catch (IllegalStateException e) {
            return makeRandomMenu(menus);
        }
    }

    private Menu generateRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return new Menu(menu);
    }

    public void validateMenu(Menu uncheckedMenu) {
        validateDuplicateRandomMenu(uncheckedMenu);
    }

    public void validateDuplicateRandomMenu(Menu uncheckedMenu) {
        if(result.contains(uncheckedMenu)) {
            throw new IllegalStateException(MenuException.DUPLICATE_MENU.getExceptionMessage());
        }
    }
}
