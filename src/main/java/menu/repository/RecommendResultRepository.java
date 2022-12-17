package menu.repository;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.DayWeek;
import menu.domain.RecommendResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RecommendResultRepository {

    private final Map<DayWeek, Category> categoryResultStorage = new ConcurrentHashMap<>();

    private final Map<Coach, List<RecommendResult>> menuResultStorage = new ConcurrentHashMap<>();

    public void saveCategoryResult(DayWeek dayWeek, Category category) {
        categoryResultStorage.put(dayWeek, category);
    }

    public void saveMenuResult(Coach coach, RecommendResult recommendResult) {
        List<RecommendResult> results = menuResultStorage.getOrDefault(coach, new ArrayList<>());
        results.add(recommendResult);
        menuResultStorage.put(coach, results);
    }

    public List<Category> findCategoryByDayWeek() {
        List<Category> categories = new ArrayList<>();
        for (DayWeek dayWeek : DayWeek.values()) {
            Category categoryResult = categoryResultStorage.get(dayWeek);
            categories.add(categoryResult);
        }
        return categories;
    }

    public List<RecommendResult> findRecommendResultByCoach(Coach coach) {
        return menuResultStorage.get(coach);
    }
}
