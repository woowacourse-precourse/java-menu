package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.enums.Menu;

public class RecommendMenu {
    private final List<Menu> menus = new ArrayList<>();

    public RecommendMenu(final List<String> menus) {
        this.menus.addAll(menus.stream()
                .map(Menu::getMenu)
                .collect(Collectors.toList()));
    }
}
