package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationMenu {
    String coachName;
    List<String> menu;

    public RecommendationMenu(String coachName, List<String> menu) {
        this.coachName = coachName;
        this.menu = menu;
    }

    public void addFood(String food) {
        this.menu.add(food);
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenu() {
        return menu;
    }
}
