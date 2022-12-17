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
            Menu menu = makeRandomMenu(menus, coachMenu);
            coachMenu.add(menu);
        }
        return coachMenu;
    }

    private Menu makeRandomMenu(List<String> menus, List<Menu> coachMenu) {
        try {
            Menu menu = generateRandomMenu(menus);
            validateMenu(menu, coachMenu);
            return menu;
        } catch (IllegalStateException e) {
            return makeRandomMenu(menus, coachMenu);
        }
    }

    private Menu generateRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return new Menu(menu);
    }

    private void validateMenu(Menu uncheckedMenu, List<Menu> menus) {
        validateDuplicateRandomMenu(uncheckedMenu, menus);
        validateCannotEatRandomMenu(uncheckedMenu);
    }

    private void validateDuplicateRandomMenu(Menu uncheckedMenu, List<Menu> menus) {
        if(menus.contains(uncheckedMenu)) {
            throw new IllegalStateException(MenuException.DUPLICATE_MENU.getExceptionMessage());
        }
    }

    private void validateCannotEatRandomMenu(Menu uncheckedMenu) {
        boolean cannotEat = coach.existsCannotEatMenus(uncheckedMenu);
        if(cannotEat) {
            throw new IllegalStateException(MenuException.CAN_NOT_MENU.getExceptionMessage());
        }
    }
}
