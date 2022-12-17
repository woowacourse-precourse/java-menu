package menu.domain;

import menu.utils.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.utils.Constant.CATEGORY_DUPLICATION_LIMIT;

public class Category {
    private final List<String> categories;
    private final List<Menu> menus;
    private final Map<String, Integer> categoryChecker;

    public Category() {
        this.categories = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.categoryChecker = new HashMap<>();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public boolean addCategory(Menu menu) {
        String category = menu.getName();
        if (categoryChecker.containsKey(category) &&
                categoryChecker.get(category) == CATEGORY_DUPLICATION_LIMIT) {
            return false;
        }
        categories.add(category);
        menus.add(menu);
        categoryChecker.put(category,
                categoryChecker.getOrDefault(category, 0) + 1);
        return true;
    }

    public String categoryResult() {
        return "[ 카테고리 | " + String.join(" | ", categories) + " ]";
    }
}
