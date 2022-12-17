package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.system.exception.CategoryDuplicatedException;
import menu.system.exception.MenuAlreadyRecommendedException;
import menu.vo.Day;

import java.util.*;

public class RecommendingService {
    private static final List<Category> categories = new ArrayList<>();

    public static void doRecommending() {
        for (Day day : Day.values()) {
            Category category = getCategory();
            categories.add(category);
            recommendMenusToCoaches(day, category);
        }
    }

    private static Category getCategory() {
        while (true) {
            try {
                Category category = Category.findByCommand(Randoms.pickNumberInRange(1, 5));
                Validator.validateOnCategory(category);
                return category;
            } catch (CategoryDuplicatedException e) {}
        }
    }

    private static void recommendMenusToCoaches(Day day, Category category) {
        for (Coach coach : CoachRepository.findAll()) {
            recommendMenusToCoach(day, category, coach);
        }
    }

    private static void recommendMenusToCoach(Day day, Category category, Coach coach) {
        while (true) {
            try {
                Menu menu = MenuRepository.findRandomOneByCategoryAndCoach(category, coach);
                RecommendingRepository.save(day, new Recommending(coach, category, menu));
                return;
            } catch (MenuAlreadyRecommendedException e) {}
        }
    }

    public static List<Category> getRecommendedCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static Map<Coach, List<Menu>> getMenusPerCoach() {
        HashMap<Coach, List<Menu>> recommendedMenusByCoach = new HashMap<>();
        for (Coach coach : CoachRepository.findAll()) {
            List<Menu> recommendedMenus = RecommendingRepository.findAllMenusByCoach(coach);
            recommendedMenusByCoach.put(coach, recommendedMenus);
        }
        return recommendedMenusByCoach;
    }

    private static class Validator {
        public static void validateOnCategory(Category category) {
            if (Category.maxFrequency < Collections.frequency(categories, category)) {
                throw new CategoryDuplicatedException();
            }
        }
    }
}
