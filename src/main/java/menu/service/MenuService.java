package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.dto.Recommendation;
import menu.repository.MenuRepository;
import menu.view.OutputView;

public class MenuService {

    public Recommendation recommend(List<Coach> coaches) {
        Map<Coach, Map<Day, String>> recommendation = new HashMap<>();
        Map<Day, Category> categories = new HashMap<>();
        for (Day day : Day.values()) {
            Category randomCategory = getRandomCategory();
            storeCategories(categories, day, randomCategory);
            recommendPerCoach(recommendation, coaches, day, randomCategory);
        }
        return new Recommendation(recommendation, categories);
    }

    private void recommendPerCoach(Map<Coach, Map<Day, String>> recommendation,
            List<Coach> coaches, Day day, Category randomCategory
    ) {
        for (Coach coach : coaches) {
            String randomMenu = getRandomMenu(randomCategory);
            storeRecommendation(recommendation, coach, day, randomMenu);
        }
    }

    private Category getRandomCategory() {
        while (true) {
            try {
                int random = Randoms.pickNumberInRange(1, 5);
                return Category.from(random);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String getRandomMenu(Category category) {
        List<String> menus = MenuRepository.findByCategory(category);
        return Randoms.shuffle(menus).get(0);
    }

    private void storeCategories(Map<Day, Category> categories, Day day, Category category) {
        categories.put(day, category);
    }

    private void storeRecommendation(
            Map<Coach, Map<Day, String>> recommendation, Coach coach, Day day, String menu
    ) {
        recommendation.computeIfAbsent(coach, m -> new HashMap<>()).put(day, menu);
    }
}
