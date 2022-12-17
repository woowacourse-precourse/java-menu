package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static menu.constant.SystemConstant.*;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static void addCoaches(List<String> coachNames) {
        validateCoachCount(coachNames);
        coachNames.forEach(coachName -> coaches.add(new Coach(coachName)));
    }

    public static void clearCoaches() {
        coaches.clear();
    }

    public static void addDislikeMenus(Coach coach, List<Menu> menus) {
        menus.forEach(coach::addDislikeMenu);
    }

    public static List<Coach> getCoaches() {
        return coaches;
    }

    public static Map<String, List<String>> getCoachesRecommendMenus() {
        Map<String, List<String>> coachesRecommendMenus = new LinkedHashMap<>();
        coaches.forEach(coach -> {
            coachesRecommendMenus.put(
                    coach.getCoachName(),
                    coach.getRecommendMenus().stream()
                            .map(Menu::getMenuName)
                            .collect(Collectors.toUnmodifiableList()));
        });
        return coachesRecommendMenus;
    }

    private static void validateCoachCount(List<String> coachNames) {
        if (coachNames.size() > COACH_MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 수는 최대 " + COACH_MAX_COUNT + "명 입니다.");
        }
        if (coachNames.size() < COACH_MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 수는 최소 " + COACH_MIN_COUNT + "명 입니다.");
        }
    }
}
