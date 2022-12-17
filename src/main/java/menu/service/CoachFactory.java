package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class CoachFactory {
    public static List<Coach> makeCoaches(String[] inputCoaches) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : inputCoaches) {
            Coach coach = new Coach(name);
            if (coaches.contains(coach)) {
                continue;
            }
            coaches.add(new Coach(name));
        }
        validateSameCoaches(inputCoaches, coaches);
        validateCoaches(coaches);
        return coaches;
    }

    private static void validateSameCoaches(String[] inputCoaches, List<Coach> coaches) {
        if (coaches.size() != inputCoaches.length) {
            throw new IllegalArgumentException(" 이름은 각각 달라야 합니다.");
        }
    }

    private static void validateCoaches(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(" 코치는 최소 2명, 최대 5명만 가능합니다.");
        }
    }
}
