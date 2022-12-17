package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category {

    public static final int FIRST_INDEX = 0;
    private final String name;
    private final List<Menu> menus = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addMenusToCategory(List<Menu> menus) {
        this.menus.addAll(menus);
    }

    public Menu pickRandomMenu() {
        String menu = Randoms.shuffle(convertMenuToName()).get(FIRST_INDEX);
        return MenuRepository.findByName(menu);
    }

    private List<String> convertMenuToName() {
        return menus.stream().map(Menu::getName).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return name;
    }

}
