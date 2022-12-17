package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {

    private static final String INVALID_FOOD_NAME_MESSAGE = "해당 코치가 없습니다. 올바른 코치 이름을 입력해주세요.";
    public static final List<Coach> coaches = new ArrayList<>();

    public static void addCoaches(Coach coach) {
        coaches.add(coach);
    }

    public static boolean isUniqueName(String name) {
        return coaches.stream()
                .noneMatch(coach -> coach.hasSameName(name));
    }

    public static List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
