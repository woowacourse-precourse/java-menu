package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.exception.CannotRecommendCategoryException;
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

    public List<Menu> recommendMenus(List<Category> categories) {
        List<Menu> recommendMenus = new ArrayList<>();
        for (Category category : categories) {
            Menus candidateMenus = menus.get(category);
            recommendMenus.add(candidateMenus.pickRandomMenu());
        }

        return recommendMenus;
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
