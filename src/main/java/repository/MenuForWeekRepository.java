package repository;

import constant.Category;
import constant.Week;
import menu.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MenuForWeekRepository {
    private static HashMap<Week, Category> categoriesPerWeek = new HashMap<>();
    private static HashMap<Coach, List<String>> menusPerCoach = new HashMap<>();

    public static HashMap<Coach, List<String>> getMenuResult() {
        return menusPerCoach;
    }

    public static HashMap<Week, Category> getCategoriesPerWeek() {
        return categoriesPerWeek;
    }

    public static boolean isCategoryAvailableToAdd(Category recommendCategory) {
        int sameCategoryCounts = (int) categoriesPerWeek.values().stream()
                .filter(category -> category.equals(recommendCategory))
                .count();
        return sameCategoryCounts < 2;
    }

    public static void addCategory(Week weekday, Category category) {
        categoriesPerWeek.put(weekday, category);
    }

    public static void addMenu(Coach coach, String recommendMenu) {
        List<String> updatedMenu = menusPerCoach.get(coach);
        updatedMenu.add(recommendMenu);
        menusPerCoach.put(coach, updatedMenu);
    }

    public static boolean didCoachEat(Coach coach, String recommendMenu) {
        return menusPerCoach.get(coach).stream()
                .anyMatch(hateMenu -> hateMenu.equals(recommendMenu));
    }

    public static void initializeCoaches(List<Coach> coaches) {
        coaches.stream().forEach(coach -> menusPerCoach.put(coach, new ArrayList<>()));
    }
}
