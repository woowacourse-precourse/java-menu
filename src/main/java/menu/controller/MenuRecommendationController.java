package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.model.MenuRecommendation;

import java.util.ArrayList;
import java.util.List;

import static menu.view.View.*;

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
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            for (int j = 0; j < coaches.size(); j++) {
                Coach coach = coaches.get(j);
                coach.addRecommendedMenus(recommendation.getRandomMenu(coach, category));
            }
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
