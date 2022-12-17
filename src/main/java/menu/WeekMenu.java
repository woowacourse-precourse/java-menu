package menu;

import java.util.ArrayList;
import java.util.List;

public class WeekMenu {
    private final List<DayMenu> weekMenu;

    public WeekMenu() {
        this.weekMenu = new ArrayList<>();
    }

    public List<DayMenu> getWeekMenu() {
        return weekMenu;

    }

    public DayMenu getDayMenu(int index) {
        return weekMenu.get(index);
    }
}
