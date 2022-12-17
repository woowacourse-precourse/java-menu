package menu.domain;

import menu.vo.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendingRepository {
    private static final Map<Day, List<Recommending>> recommendings = new HashMap<>();

    public static void save(Day day, Recommending recommending) {
        if (recommendings.get(day) == null) {
            recommendings.put(day, new ArrayList<>());
        }
        recommendings.get(day).add(recommending);
    }
}
