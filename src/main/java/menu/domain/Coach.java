package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String coachName;
    private final List<Menu> cannotEatMenus = new ArrayList<>();
    private final List<Menu> recommendMenus;

    public Coach(String coachName, List<String> cannotEatMenus) {
        this.coachName = coachName;
        this.recommendMenus = new ArrayList<>();
        for(String menu : cannotEatMenus) {
            this.cannotEatMenus.add(new Menu(menu));
        }
    }

    public boolean existsCannotEatMenus(Menu menu) {
        for(Menu cannotEatMenu : cannotEatMenus) {
            if(cannotEatMenu == menu) {
                return true;
            }
        }
        return false;
    }

    public List<Menu> getRecommendMenus() {
        return recommendMenus;
    }

    public String getCoachName() {
        return coachName;
    }
}
