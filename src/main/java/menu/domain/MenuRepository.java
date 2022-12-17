package menu.domain;

import java.util.ArrayList;
import java.util.List;

import static menu.constant.SystemConstant.ERROR_PREFIX;

public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    public static void addMenu(String menuName, Category category) {
        menus.add(new Menu(menuName, category));
    }

    public static Menu findByName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.isSameName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 메뉴를 입력하셨습니다."));
    }
}
