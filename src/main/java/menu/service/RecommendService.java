package menu.service;

import menu.domain.Category;
import menu.domain.Day;
import menu.repository.WeeklyMenuRepository;

import java.util.Arrays;

public class RecommendService {
    private WeeklyMenuRepository weeklyMenuRepository = new WeeklyMenuRepository();

    public void createWeeklyRecommendMenu() {
        Arrays.stream(Day.values())
                .forEach(day -> recommendMenu(day));
    }

    private void recommendMenu(Day day) {
        Category category = getValidCategory();
            }

    private Category getValidCategory() {
        while (true) {
            Category randomCategory = Category.getRandomCategory();
            if (weeklyMenuRepository.isValidCategory(randomCategory)) {
                return randomCategory;
            }
        }
    }
}
