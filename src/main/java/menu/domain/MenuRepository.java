package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRepository {
    private static final Map<Category, List<Menu>> menus = new HashMap<>();
    private static final Map<Coach, List<Menu>> bannedMenus = new HashMap<>();

    public static void save(Category category, List<String> menuNames) {
        List<Menu> menuArrays = menuNames.stream().map(Menu::new).collect(Collectors.toList());
        menus.put(category, menuArrays);
    }

    public static void saveBannedMenu(Coach coach, List<Menu> bannedMenusToSave) {
        Validator.validateOnSavingBannedMenu(bannedMenusToSave);
        bannedMenus.put(coach, bannedMenusToSave);
    }

    public static Menu findRandomOneByCategoryAndCoach(Category category, Coach coach) {
        List<String> menuNames = findAllNamesByCategoryAndCoach(category, coach);
        String menu = Randoms.shuffle(menuNames).get(0);
        return new Menu(menu);
    }

    private static List<String> findAllNamesByCategoryAndCoach(Category category, Coach coach) {
        return menus.get(category)
                .stream().filter(menu -> !bannedMenus.get(coach).contains(menu))
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    private static class Validator {

        public static final String INVALID_BANNED_MENU_SIZE = "각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.";

        public static void validateOnSavingBannedMenu(List<Menu> bannedMenusToSave) {
            if (bannedMenusToSave.size() < Menu.MIN_BANNED_MENU || Menu.MAX_BANNED_MENU < bannedMenusToSave.size()) {
                throw new IllegalArgumentException(INVALID_BANNED_MENU_SIZE);
            }
        }
    }
}
