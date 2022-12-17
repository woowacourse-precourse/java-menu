package menu.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class RecommendResult {
    private DayOfTheWeek dayOfTheWeek;
    private MenuCategory menuCategory;
    private Map<Coach, Menu> coachAndMenu;

    public RecommendResult(DayOfTheWeek dayOfTheWeek, MenuCategory menuCategory) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.menuCategory = menuCategory;
        coachAndMenu = new HashMap<>();
    }

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}
