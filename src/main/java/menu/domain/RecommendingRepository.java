package menu.domain;

import menu.vo.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendingRepository {
    private static final Map<Day, List<Recommending>> recommendings = new HashMap<>();
    public static final String RECOMMENDING_NOT_FOUND = "시스템 예외: 추천을 못하는 경우는 발생하지 않아야 한다.";

    public static void save(Day day, Recommending recommending) {
        if (recommendings.get(day) == null) {
            recommendings.put(day, new ArrayList<>());
        }
        recommendings.get(day).add(recommending);
    }

    public static List<Menu> findAllMenusByCoach(Coach coach) {
        List<Menu> menus = new ArrayList<>();
        for (Day day : Day.values()) {
            menus.add(recommendings.get(day)
                    .stream().filter(recommending -> recommending.isCoach(coach))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(RECOMMENDING_NOT_FOUND))
                    .getMenu());
        }
        return menus;
    }
}
