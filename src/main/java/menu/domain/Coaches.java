package menu.domain;

import menu.utills.Recommender;
import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    // TODO: refactoring indent, line
    public void takeRecommend() {
        for (Coach coach : coaches) {
            while (coach.isAllRecommended()) {
                Category category = Recommender.getRandomCategory();
                List<String> menuNames = MenuRepository.getMenuNamesByCategory(category);
                String menuName = Recommender.getRandomMenuName(menuNames);
                Menu menu = MenuRepository.getMenuByName(menuName);
                coach.addRecommendedMenu(menu);
            }
        }
    }
}

