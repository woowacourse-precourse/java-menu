package menu.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {

    private static final String INVALID_FOOD_NAME_MESSAGE = "해당 코치가 없습니다. 올바른 코치 이름을 입력해주세요.";
    public static final List<Coach> coaches = new ArrayList<>();

    static {
        addCoaches(new Coach("토미", Arrays.asList("우동", "스시")));
        addCoaches(new Coach("제임스", Arrays.asList("뇨끼", "월남쌈")));
        addCoaches(new Coach("포코", Arrays.asList("마파두부", "고추잡채")));
    }
    
    public static void addCoaches(Coach coach) {
        coaches.add(coach);
    }

    public static List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
