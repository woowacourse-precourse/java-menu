package menu.service;

import menu.domain.*;
import menu.utills.Recommender;
import menu.utills.constants.Category;

import java.util.List;

public class Service {
    private final Coaches coaches = new Coaches();
    private final Categories categories = new Categories();

    public void setMenus() {
        MenuRepository.initialize();
    }

    public void setCoach(List<String> coachNames, List<List<String>> hateMenus) {
        for (int i = 0; i < coachNames.size(); i++) {
            Coach newCoach = new Coach(coachNames.get(i));
            coaches.addCoach(newCoach);
            addHateMenu(newCoach, hateMenus.get(i));
        }
    }

    public void recommend() {
        setCategories();
        coaches.takeRecommendByCategories(categories.getCategories());
    }

    private void addHateMenu(Coach coach, List<String> hateMenuNames) {
        for (String menuName : hateMenuNames) {
            Menu menu = MenuRepository.getMenuByName(menuName);
            coach.addHateMenu(menu);
        }
    }

    private void setCategories() {
        while (!categories.isFull()) {
            Category category = Recommender.getRandomCategory();
            categories.addCategories(category);
        }
    }
}
