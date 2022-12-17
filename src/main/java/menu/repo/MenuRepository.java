package menu.repo;

import menu.domain.Category;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private Long id = 0L;
    private final Map<Long, Menu> menus = new HashMap<>();
    private static MenuRepository menuRepository = new MenuRepository();

    private MenuRepository() {
    }

    public static MenuRepository getInstance() {
        return menuRepository;
    }

    public Long save(Menu menu) {
        menus.put(id, menu);
        return id++;
    }

    public Menu findById(Long id) {
        return menus.get(id);
    }

    public List<Menu> findAll() {
        return new ArrayList<>(menus.values());
    }

    public List<String> findMenusAllByCategory(Category category) {
        Menu menu = findByCategory(category);
        return menu.getMenus();
    }

    private Menu findByCategory(Category category) {
        Menu menu = menus.values().stream()
                .filter(o -> o.getCategory().equals(category))
                .findFirst().orElse(null);
        return menu;
    }
}
