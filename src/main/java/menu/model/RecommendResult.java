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

    public Map<Coach, Menu> getCoachAndMenu() {
        return coachAndMenu;
    }

    private Map<Coach, Menu> coachAndMenu;

    public RecommendResult(DayOfTheWeek dayOfTheWeek, MenuCategory menuCategory) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.menuCategory = menuCategory;
        this.coachAndMenu = new HashMap<>();
    }

    public DayOfTheWeek getDayOfTheWeek() {
        return this.dayOfTheWeek;
    }

    public MenuCategory getMenuCategory() {
        return this.menuCategory;
    }

    public void setCoachAndMenu(Coach coach, Menu menu) {
        this.coachAndMenu.put(coach, menu);
    }
}
