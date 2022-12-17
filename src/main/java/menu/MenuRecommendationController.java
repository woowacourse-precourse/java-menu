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

    public void run() {
        printStartMessage();
        makeCoaches(requestInputCoachName());
        setUnwantedMenus();
        categories = recommendation.getRandomCategories();
        recommendMenus();
        printResult(coaches, categories);
    }

    private void makeCoaches(List<String> coachNames) {
        for (int i = 0; i < coachNames.size(); i++) {
            Coach coach = new Coach(coachNames.get(i));
            coaches.add(coach);
        }
    }

    private void recommendMenus() {
        for (int i = 0; i < coaches.size(); i++) {
            Coach coach = coaches.get(i);
            coach.setRecommendedMenus(recommendation.getRandomMenus(coach));
        }
    }

    private void setUnwantedMenus() {
        for (int i = 0; i < coaches.size(); i++) {
            Coach coach = coaches.get(i);
            List<String> unwantedMenus = requestUnwantedMenu(coach.getName());
            coach.setUnwantedMenus(unwantedMenus);
        }
    }
}
