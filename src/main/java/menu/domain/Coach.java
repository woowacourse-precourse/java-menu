package menu.domain;

import java.util.List;

public class Coach {

    private String name;
    private List<Menu> hateMenus;
    private List<Menu> recommendMenus;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public void addHateMenus(List<Menu> hateMenus) {
        this.hateMenus = hateMenus;
    }
    public void addRecommendMenus(List<Menu> recommendMenus) {
        this.recommendMenus = recommendMenus;
    }

    public List<Menu> getHateMenu() {
        return hateMenus;
    }
}
