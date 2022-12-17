package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.exception.CannotRecommendCategoryException;
import menu.exception.CannotRecommendMenuException;
import menu.util.Validator;

public class MenuRecommender {

    private final Map<Category, Menus> menus;

    public MenuRecommender(Map<Category, Menus> menus) {
        this.menus = menus;
    }

    public List<Category> recommendCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            try {
                Category category = Category.pickRandomCategory();
                Validator.validateCategories(category, categories);
                categories.add(category);
            } catch (CannotRecommendCategoryException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return categories;
    }

    public List<String> recommendMenus(Coach coach, List<Category> categories) {
        try {
            List<String> recommendMenus = new ArrayList<>();
            for (Category category : categories) {
                recommendMenu(category, coach, recommendMenus);
            }
            Validator.validateRecommendMenus(recommendMenus);
            return recommendMenus;
        } catch (CannotRecommendMenuException exception) {
            System.out.println(exception.getMessage());
        }
        return recommendMenus(coach, categories);
    }

    private void recommendMenu(Category category, Coach coach, List<String> recommendMenus) {
        Menus candidateMenus = menus.get(category);
        String menu = candidateMenus.pickRandomMenu();
        if (!coach.isBannedMenu(menu)) {
            recommendMenus.add(menu);
            return;
        }
        recommendMenu(category, coach, recommendMenus);
    }

    public boolean isExistedMenu(String menu) {
        for (Menus menus : this.menus.values()) {
            if (menus.isExistedMenu(menu)) {
                return true;
            }
        }
        return false;
    }
}
