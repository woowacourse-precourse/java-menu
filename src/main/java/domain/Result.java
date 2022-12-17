package domain;

import java.util.Map;

public class Result {
    private final Map<DayOfWeek, DayCategoryMenu> results;

    public Result(Map<DayOfWeek, DayCategoryMenu> results) {
        this.results = results;
    }

    public Map<DayOfWeek, DayCategoryMenu> getResults() {
        return results;
    }
}
