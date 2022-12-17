package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> refuseMenus;
    private final List<String> recommendMenus;

    public Coach(String name) {
        this.name = name;
        this.refuseMenus = new ArrayList<>();
        this.recommendMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getRefuseMenus() {
        return refuseMenus;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }

    public void addRecommendMenu(String menu) {
        this.recommendMenus.add(menu);
    }

    public boolean isFirstRecommendMenu(String menu) {
        return !recommendMenus.contains(menu);
    }

    public boolean isNotRefuseMenu(String menu) {
        return !refuseMenus.contains(menu);
    }
}
