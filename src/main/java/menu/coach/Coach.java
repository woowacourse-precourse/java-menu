package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> cannotEat = new ArrayList<>();
    private List<String> recommendedMenu = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void setCannotEat(List<String> cannotEat) {
        this.cannotEat = cannotEat;
    }

    public void setRecommendedMenu(List<String> recommendedMenu) {
        this.recommendedMenu = recommendedMenu;
    }

}
