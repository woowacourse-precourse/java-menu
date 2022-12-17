package menu.domain.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Menu;
import menu.utils.ExceptionType;

public class MenuRepository {

    private static final List<Menu> menuRepository = new ArrayList<>();

    public static void addMenu(Menu menu) {
        if(!menuRepository.contains(menu)) {
            menuRepository.add(menu);
        }
    }

    public static Menu getMenuByMenuName(String menuName) {
        return menuRepository.stream()
                .filter(menu -> menu.name().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionType.IS_NOT_IN_MENU.toString()));
    }

    public static boolean isExistMenu(Menu menu) {
        return menuRepository.contains(menu);
    }
}
