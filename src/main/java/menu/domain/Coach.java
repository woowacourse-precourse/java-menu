package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.utils.Validation;

public class Coach {

    private final String name;
    private List<String> cantEatMenus;
    private List<Menu> menus;

    public Coach(String name) {
        Validation.isCoachName(name);
        this.name = name;
        menus = new ArrayList<>();
    }

    public void setCantEatMenus(List<String> cantEatMenus) {
        Validation.isMenus(cantEatMenus);
        this.cantEatMenus = cantEatMenus;
    }

    public void addMenu(Menu menu) {
        validateAboutAddMenu(menu);
        menus.add(menu);
    }

    private void validateAboutAddMenu(Menu menu) {
        isFineAboutCategory(menu.getCategory());
        isNotDuplicateMenu(menu);
    }

    public void isFineAboutCategory(Category category) {
        List<Menu> duplicationCategory = menus.stream()
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());

        if (duplicationCategory.size() > 2) {
            throw new IllegalArgumentException();
        }
    }

    public void isNotDuplicateMenu(Menu menu) {
        if (menus.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    public int getMenusSize() {
        return menus.size();
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        List<String> resultMenus = new ArrayList<>();
        for (Menu menu : menus) {
            resultMenus.add(menu.getName());
        }
        return resultMenus;
    }
}
