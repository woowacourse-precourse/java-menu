package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static menu.constant.SystemConstant.*;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();
    private static final List<Category> categories = new ArrayList<>();

    public static void addCoaches(List<String> coachNames) {
        validateCoachCount(coachNames);
        coachNames.forEach(coachName -> coaches.add(new Coach(coachName)));
    }

    public static void clearCoaches() {
        coaches.clear();
    }

    public static List<Coach> getCoaches() {
        return coaches;
    }

    public static void addDislikeMenus(Coach coach, List<Menu> menus) {
        menus.forEach(coach::addDislikeMenu);
    }

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static boolean checkTooManySameCategory(Category category) {
        List<Category> distinctCategories =  categories.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        if (distinctCategories.size() == MAX_CATEGORY_COUNT) {
            return !distinctCategories.contains(category);
        }
        return true;
    }

    public static List<String> getRecommendCategoriesName() {
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Map<String, List<String>> getCoachesRecommendMenus() {
        Map<String, List<String>> coachesRecommendMenus = new LinkedHashMap<>();
        coaches.forEach(coach -> {
            coachesRecommendMenus.put(
                    coach.getCoachName(),
                    coach.getRecommendMenus().stream()
                            .map(Menu::getMenuName)
                            .collect(Collectors.toUnmodifiableList()));
        });
        return coachesRecommendMenus;
    }

    private static void validateCoachCount(List<String> coachNames) {
        if (coachNames.size() > COACH_MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최대 " + COACH_MAX_COUNT + "명까지만 입력해야 합니다." );
        }
        if (coachNames.size() < COACH_MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최소 " + COACH_MIN_COUNT + "명 이상 입력해야 합니다." );
        }
    }
}
