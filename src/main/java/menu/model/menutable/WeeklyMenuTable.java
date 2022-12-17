package menu.model.menutable;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenuTable {
    private List<DailyMenuTable> menuTable;
    WeeklyMenuTable(List<DailyMenuTable> menuTable) {
        this.menuTable = new ArrayList<>(menuTable);
    }

    public String getMenu(int date, String coachName) {
        return menuTable.get(date).getMenu(coachName);
    }
}
