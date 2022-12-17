package menu.domain.repository;

import menu.domain.model.Category;
import menu.domain.model.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {

    private static final List<Menu> menus;
    private static final String ERROR_NOT_EXIST_MENU = "[ERROR] 해당 이름의 메뉴는 없습니다.";

    static {
        menus = MenuCreator.create();
    }

    private MenuRepository() {
    }

    public static List<Menu> findAll() {
        return Collections.unmodifiableList(menus);
    }

    public static List<Menu> findByNames(List<String> names) {
        List<Menu> result = new ArrayList<>();
        for (String name : names) {
            Menu findMenu = findMenuByName(name);
            result.add(findMenu);
        }
        return result;
    }

    public static Menu findMenuByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_MENU));
    }

    public static List<Menu> findByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.isEqualCategory(category))
                .collect(Collectors.toList());
    }
}
