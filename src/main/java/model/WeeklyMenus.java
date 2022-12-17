package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeeklyMenus {
    
    private final Map<Coach, WeeklyMenu> weeklyMenus;
    private final List<Category> categories;
    
    public WeeklyMenus() {
        this.weeklyMenus = new LinkedHashMap<>();
        this.categories = new ArrayList<>();
    }
}
