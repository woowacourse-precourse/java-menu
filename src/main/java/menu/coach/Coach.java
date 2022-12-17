package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> menusCannotEats = new ArrayList<>();
    private List<String> menusRecommended = new ArrayList<>(); // 순서 : 월, 화, 수, 목, 금

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenusCannotEats() {
        return menusCannotEats;
    }

    public List<String> getMenusRecommended() {
        return menusRecommended;
    }

    public void setMenusRecommended(List<String> recommendedMenu) {
        this.menusRecommended = recommendedMenu;
    }

    public void addMenusCannotEats(String cannotEat) {
        this.menusCannotEats.add(cannotEat);
    }

}
