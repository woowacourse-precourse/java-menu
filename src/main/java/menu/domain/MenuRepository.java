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
        bannedMenus.put(coach, bannedMenusToSave);
    }

    public static List<Menu> findAllByCategory(Category category) {
        return menus.get(category);
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
}
