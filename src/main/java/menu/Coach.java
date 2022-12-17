package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> hateFoods;
    private List<String> categories;
    private List<String> menus = new ArrayList<>();

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
    }

    public boolean isHate(String menu) {
        return hateFoods.contains(menu);
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public List<String> getMenus() {
        return menus;
    }

    public String toString() {
        return "[ " + name + " | " + String.join(" | ", menus) + " ]";
    }
}
