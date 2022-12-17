package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> cannotEatMenus = new ArrayList<>();
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCannotEat(String cannotEat) {
        this.cannotEatMenus.add(cannotEat);
    }

    public void setRecommendedMenu(List<String> recommendedMenu) {
        this.recommendedMenus = recommendedMenu;
    }

}
