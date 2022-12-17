package menu;

import java.util.ArrayList;
import java.util.List;

import static menu.View.*;

public class MenuRecommendationController {
    MenuRecommendation recommendation;
    List<Coach> coaches = new ArrayList<>();
    List<Category> categories = new ArrayList<>();

    public MenuRecommendationController() {
        recommendation = new MenuRecommendation();
    }

    private void makeCoaches(List<String> coachNames) {
        for (int i = 0; i < coachNames.size(); i++) {
            Coach coach = new Coach(coachNames.get(i));
            coaches.add(coach);
        }
    }

}
