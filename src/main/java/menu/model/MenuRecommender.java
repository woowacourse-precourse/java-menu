package menu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.domain.Coaches;

public class MenuRecommender {
    public static final int DAY_SIZE = 5;

    private final Coaches coaches;
    private final Map<Coach, List<String>> coachMenus = new LinkedHashMap<>();
    private final List<Category> dailyCategories = new ArrayList<>();

    public MenuRecommender(Coaches coaches) {
        this.coaches = coaches;
        coaches.coaches()
                .forEach(coach -> coachMenus.put(coach, new ArrayList<>()));
        updateDailyCategories();
        updateCoachMenus();
    }

    private void updateDailyCategories() {
        while (dailyCategories.size() < DAY_SIZE) {
            Category category = MenuPicker.pickCategory();
            if (!dailyCategories.contains(category)) {
                dailyCategories.add(category);
            }
        }
    }

    public List<String> getDailyCategories() {
        // TODO IllegalState 예외처리
        return dailyCategories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    private void updateCoachMenus() {
        // TODO IllegalState 예외처리
        dailyCategories.forEach(this::updateCoachMenusByCategory);
    }

    public Map<String, List<String>> getCoachMenus() {
        // TODO IllegalState 예외처리
        Map<String, List<String>> result = coachMenus.keySet()
                .stream()
                .collect(Collectors.toMap(Coach::getName, coachMenus::get));
        return new LinkedHashMap<>(result);
    }

    private void updateCoachMenusByCategory(Category category) {
        coaches.coaches()
                .forEach(coach -> pickMenusForCoach(category, coach));
    }

    private void pickMenusForCoach(Category category, Coach coach) {
        List<String> currentMenus = coachMenus.get(coach);
        String menu = category.getRandomMenu();
        if (menu == null || currentMenus.contains(menu) || coach.dislike(menu)) {
            pickMenusForCoach(category, coach);
            return;
        }
        currentMenus.add(menu);
        coachMenus.put(coach, currentMenus);
    }
}
