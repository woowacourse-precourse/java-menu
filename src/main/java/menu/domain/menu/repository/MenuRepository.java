package menu.domain.menu.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import menu.domain.menu.Category;
import menu.domain.menu.entity.Menu;

public class MenuRepository {

    private final List<Menu> menus = new ArrayList<>();

    public void save(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> findAllByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.matchesByCategory(category))
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Menu> findByName(String menuName) {
        return menus.stream().filter(menu -> menu.matchesByName(menuName)).findAny();
    }
}
