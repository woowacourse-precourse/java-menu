package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Menu;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    public static void add(Menu menu) {
        menus.add(menu);
    }

    public static Menu findByName(String name) {
        return menus.stream().filter(menu -> menu.getName().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 이름을 가지는 메뉴가 없습니다."));
    }

}
