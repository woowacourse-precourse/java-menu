package menu.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.utils.ExceptionType;

public class MenuRepository {

    private static final List<Menu> menuRepository = new ArrayList<>();

    public static void addMenu(Menu menu) {
        menuRepository.add(menu);
    }

    public static Menu getMenuByMenuName(String menuName) {
        return menuRepository.stream()
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionType.IS_NOT_IN_MENU.toString()));
    }

    public static boolean isExistMenu(Menu menu) {
        return menuRepository.contains(menu);
    }

    public static void isExistMenuByName(String menuName) {
        menuRepository.stream()
                .filter(menu -> menu.getName().equals(menuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionType.IS_NOT_IN_MENU.toString()));
    }

    public static List<Menu> getMenusByCategory(Category category) {
        return menuRepository.stream()
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
