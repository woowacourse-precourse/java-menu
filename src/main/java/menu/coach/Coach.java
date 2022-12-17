package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> menusCannotEats = new ArrayList<>();
    private List<String> menusRecommended = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenusCannotEats() {
        return menusCannotEats;
    }

    public void addMenusCannotEats(String cannotEat) {
        this.menusCannotEats.add(cannotEat);
    }

    public void setRecommendedMenu(List<String> recommendedMenu) {
        this.menusRecommended = recommendedMenu;
    }

}
