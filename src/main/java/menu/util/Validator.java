package menu.util;

import java.util.List;
import menu.domain.Coach;

public class Validator {
    private static final int MIN_COACHES_SIZE = 2;
    private static final int MAX_COACHES_SIZE = 5;

    public static void validateCoaches(List<Coach> coaches) {
        validateCoachSize(coaches.size());
    }

    private static void validateCoachSize(int coachSize) {
        if (coachSize < MIN_COACHES_SIZE | coachSize > MAX_COACHES_SIZE) {
            throw new IllegalArgumentException("[ERROR] 코치의 수는 2명 이상, 5명 이하입니다.");
        }
    }
}
