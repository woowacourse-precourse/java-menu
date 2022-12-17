package menu.model;

import menu.model.init.InitData;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRepository {
    private final Map<MenuCategory, List<Menu>> menu = new EnumMap<>(MenuCategory.class);

    public MenuRepository() {
        Arrays.stream(MenuCategory.values())
                .forEach(mc -> menu.put(mc, new ArrayList<>()));
        initSetting();
    }

    public void initSetting() {
        Arrays.stream(InitData.values())
                .forEach(initData -> menu.put(initData.getMenuCategory(),
                        initData.toList()
                                .stream()
                                .map(String::trim)
                                .map(name ->
                                        new Menu(name, initData.getMenuCategory()))
                                .collect(Collectors.toList())));
    }

    public Menu findByName(String name) {
        for(MenuCategory menuCategory : MenuCategory.values()) {
            Menu m = searchByNameAndCategory(name, menuCategory);
            if (m != null) return m;
        }
        throw new IllegalArgumentException();
    }

    private Menu searchByNameAndCategory(String name, MenuCategory menuCategory) {
        for(Menu m : menu.get(menuCategory)) {
            if(m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public List<Menu> findAllByCategory(MenuCategory category) {
        return List.copyOf(menu.get(category));
    }
}
