package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeeklyMenus {
    
    private final Map<Coach, WeeklyMenu> weeklyMenus;
    private final List<Category> categories;
    
    public WeeklyMenus() {
        this.weeklyMenus = new LinkedHashMap<>();
        this.categories = new ArrayList<>();
    }
    
    public List<String> getCategories() {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
    
    public WeeklyMenu getWeeklyMenu(Coach coach) {
        return weeklyMenus.getOrDefault(coach, new WeeklyMenu());
    }
    
    public void addCategory(Category category) {
        categories.add(category);
    }
    
    public void putWeeklyMenu(Coach coach, WeeklyMenu weeklyMenu) {
        weeklyMenus.put(coach, weeklyMenu);
    }
}
