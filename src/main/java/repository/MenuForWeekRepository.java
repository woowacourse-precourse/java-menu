package repository;

import constant.Category;
import constant.Week;
import menu.Coach;

import java.util.HashMap;
import java.util.List;

public class MenuForWeekRepository {
    private static HashMap<Week, Category> categoriesPerWeek = new HashMap<>();
    private static HashMap<Coach, List<String>> hateMenus = new HashMap<>();

    public static HashMap<Coach, List<String>> getMenuResult() {
        // TODO : 반환값 변경
        return null;
    }

    public static HashMap<Week, Category> getCategoriesPerWeek() {
        // TODO : 반환값 변경
        return null;
    }

    public static boolean isCategoryAvailableToAdd(Category recommendCategory) {
        //  TODO : 카테고리가 선택된 횟수가 2번 이하라면 true
        int sameCategoryCounts = (int) categoriesPerWeek.values().stream()
                .filter(category -> category.equals(recommendCategory))
                .count();
        return sameCategoryCounts < 2;
    }

    public static void addCategory(Week weekday, Category category) {
        categoriesPerWeek.put(weekday, category);
    }
}
