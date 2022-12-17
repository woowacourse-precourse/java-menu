package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;

public class MenuRecommendController {

    private final List<Category> existCategories = new ArrayList<>();

    public void addWeekMenuOfCoaches() {
        for (int day = 0; day < 5; day++){
            addDayMenuOfCoaches(CoachRepository.coaches());
        }
    }

    private void addDayMenuOfCoaches(List<Coach> coaches) {

        Category category = getValidCategory(existCategories);
        existCategories.add(category);

        for (Coach coach : coaches) {
            addMenuOfCoach(coach, category);
        }
    }

    private void addMenuOfCoach(Coach coach, Category category) {
        Menu menu = null;
        do {
            menu = getRandomMenuByCategory(category);
        } while (!isValidMenuForCoach(coach, menu));
        coach.addRecommendMenu(menu);
    }

    private boolean isValidMenuForCoach(Coach coach, Menu menu) {
        return !isDuplicatedForCoach(coach, menu) && isEatableMenuForCoach(coach, menu);
    }

    private boolean isDuplicatedForCoach(Coach coach, Menu menu) {
        return coach.isContainForRecommend(menu);
    }

    private boolean isEatableMenuForCoach(Coach coach, Menu menu) {
        return coach.isEatable(menu);
    }

    private Menu getRandomMenuByCategory(Category category) {
        return category.getRandomMenu();
    }

    private Category getValidCategory(List<Category> existCategories) {
        Category category = null;
        do {
            category = getRandomCategory();
        } while (!isValidCategory(existCategories, category));
        return category;
    }

    private Category getRandomCategory() {
        return Category.findByNumber(Randoms.pickNumberInRange(1, 5));
    }

    private boolean isValidCategory(List<Category> existCategories, Category newCategory) {
        return existCategories.stream().filter(category -> category.equals(newCategory)).count() < 2;
    }
}
