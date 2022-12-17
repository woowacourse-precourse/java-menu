package menu.domain;

import java.util.EnumMap;
import java.util.Map;

public class RecommendResult {
    private final Map<DayOfWeek, Menu> result = new EnumMap<>(DayOfWeek.class);

    public void putMenus(DayOfWeek dayOfWeek, Menu menu) {
        result.put(dayOfWeek, menu);
    }

    public Menu getMenus(DayOfWeek dayOfWeek) {
        return result.get(dayOfWeek);
    }
}
