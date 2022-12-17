package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.vo.Day;

import java.util.*;

public class RecommendingService {
    private static final List<Category> categories = new ArrayList<>();

    public static void doRecommending() {
        for (Day day : Day.values()) {
            Category category = Category.findByCommand(Randoms.pickNumberInRange(1, 5));
            categories.add(category);
            recommendMenusToCoaches(day, category);
        }
    }

    private static void recommendMenusToCoaches(Day day, Category category) {
        for (Coach coach : CoachRepository.findAll()) {
            recommendMenusToCoach(day, category, coach);
        }
    }

    private static void recommendMenusToCoach(Day day, Category category, Coach coach) {
        Menu menu = MenuRepository.findRandomOneByCategoryAndCoach(category, coach);
        RecommendingRepository.save(day, new Recommending(coach, category, menu));
    }

    public static List<Category> getRecommendedCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static Map<Coach, List<Menu>> getMenusArraysPerCoach() {
        HashMap<Coach, List<Menu>> recommendedMenusByCoach = new HashMap<>();
        for (Coach coach : CoachRepository.findAll()) {
            List<Menu> recommendedMenus = RecommendingRepository.findAllMenusByCoach(coach);
            recommendedMenusByCoach.put(coach, recommendedMenus);
        }
        return recommendedMenusByCoach;
    }
}
