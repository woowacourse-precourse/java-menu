package menu.repository;

import menu.domain.Category;
import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MenuRepository {

    private final Map<Category, List<String>> menuStorages = new ConcurrentHashMap<>();

    private final Map<Coach, List<String>> alreadyRecommendStorages = new ConcurrentHashMap<>();

    public void saveCategoryAndMenu(Category category, List<String> menuNames) {
        menuStorages.put(category, menuNames);
    }

    public List<String> findMenusByCategory(Category findCategory) {
        return menuStorages.get(findCategory);
    }

    public boolean checkAlreadyRecommendByCoach(Coach coach, String recommendMenu) {
        List<String> menus = alreadyRecommendStorages.getOrDefault(coach, new ArrayList<>());
        if (menus.contains(recommendMenu)) {
            return true;
        }
        menus.add(recommendMenu);
        alreadyRecommendStorages.put(coach, menus);
        return false;
    }
}
