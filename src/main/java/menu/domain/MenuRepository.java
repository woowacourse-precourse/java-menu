package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
        while (true) {
            List<String> menuNames = findAllNamesByCategory(category);
            Menu menu = new Menu(getRandomMenuName(menuNames));
            if (!isBanned(coach, menu)) {
                return menu;
            }
        }
    }

    private static boolean isBanned(Coach coach, Menu menu) {
        return bannedMenus.get(coach).contains(menu);
    }

    private static String getRandomMenuName(List<String> menuNames) {
        return Randoms.shuffle(menuNames).get(0);
    }

    private static List<String> findAllNamesByCategory(Category category) {
        return menus.get(category)
                .stream().map(Menu::getName)
                .collect(Collectors.toList());
    }

    private static List<Menu> findAll() {
        ArrayList<Menu> totalMenus = new ArrayList<>();
        menus.forEach((category, menusByCategory) -> totalMenus.addAll(menusByCategory));
        return totalMenus;
    }

    private static boolean has(Menu menu) {
        return findAll().contains(menu);
    }

    private static class Validator {

        public static final String INVALID_BANNED_MENU_SIZE = "각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.";

        public static final String MENU_NOT_EXISTING = "존재하지 않는 메뉴 이름";
        public static void validateOnSavingBannedMenu(List<Menu> bannedMenusToSave) {
            for (Menu menu : bannedMenusToSave) {
                isExistingMenu(menu);
            }
            hasValidSize(bannedMenusToSave);
        }

        private static void hasValidSize(List<Menu> bannedMenusToSave) {
            if (bannedMenusToSave.size() < Menu.MIN_BANNED_MENU || Menu.MAX_BANNED_MENU < bannedMenusToSave.size()) {
                throw new IllegalArgumentException(INVALID_BANNED_MENU_SIZE);
            }
        }

        private static void isExistingMenu(Menu menu) {
            if (!MenuRepository.has(menu)) {
                throw new IllegalArgumentException(MENU_NOT_EXISTING);
            }
        }
    }
}
