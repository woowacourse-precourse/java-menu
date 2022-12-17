package menu.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.dto.Recommendation;
import menu.repository.HardToEatRepository;

public class MenuValidator {

    private MenuValidator() {
    }

    public static void validate(Recommendation recommendation) {
        validateHardToEatMenu(recommendation.getRecommendation());
        validateDuplicationCategory(recommendation.getCategories());
    }

    private static void validateHardToEatMenu(Map<Coach, Map<Day, String>> recommendation) {
        Set<Coach> coaches = recommendation.keySet();
        for (Coach coach : coaches) {
            validatePerCoach(coach, recommendation.get(coach));
        }
    }

    private static void validatePerCoach(Coach coach, Map<Day, String> menus) {
        Set<Day> days = menus.keySet();
        for (Day day : days) {
            String menu = menus.get(day);
            validateHardToEatMenuContain(coach, menu);
        }
    }

    private static void validateHardToEatMenuContain(Coach coach, String menu) {
        if (HardToEatRepository.findByCoach(coach).contains(menu)) {
            throw new IllegalStateException("먹지 못하는 메뉴가 포함되어 있다.");
        }
    }

    private static void validateDuplicationCategory(Map<Day, Category> categories) {
        Set<Day> days = categories.keySet();
        Map<Category, Integer> counts = new HashMap<>();

        for (Day day : days) {
            Category category = categories.get(day);
            counts.put(category, counts.getOrDefault(category, 0) + 1);
        }

        validateCounts(counts);
    }

    private static void validateCounts(Map<Category, Integer> counts) {
        Set<Category> categories = counts.keySet();

        for (Category category : categories) {
            validateOverCounts(counts, category);
        }
    }

    private static void validateOverCounts(Map<Category, Integer> counts, Category category) {
        if (counts.get(category) > 2) {
            throw new IllegalStateException("한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.");
        }
    }
}
