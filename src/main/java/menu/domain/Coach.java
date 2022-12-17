package menu.domain;

import java.util.List;

public class Coach {

    private String name;
    private List<Menu> hateMenu;

    public Coach(String name) {
        this.name = name;
    }

    public void addHateFoods(Menu menu) {
        hateMenu.add(menu);
    }

    public List<Menu> getHateMenu() {
        return hateMenu;
    }
}
