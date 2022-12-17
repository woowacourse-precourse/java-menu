package menu.model.menutable;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenuTable {
    private List<DailyMenuTable> menuTable;
    WeeklyMenuTable(List<DailyMenuTable> menuTable) {
        this.menuTable = new ArrayList<>(menuTable);
    }
}
