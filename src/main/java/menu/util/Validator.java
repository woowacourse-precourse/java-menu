package menu.util;

import java.util.List;
import menu.domain.Coach;

public class Validator {

    private static final int MIN_COACHES_SIZE = 2;
    private static final int MAX_COACHES_SIZE = 5;

    private static final int MIN_COACH_NAME_SIZE = 2;
    private static final int MAX_COACH_NAME_SIZE = 4;

    public static void validateCoaches(List<Coach> coaches) {
        validateCoachSize(coaches.size());
        validateCoachNameSize(coaches);
    }

    private static void validateCoachSize(int coachSize) {
        if (coachSize < MIN_COACHES_SIZE | coachSize > MAX_COACHES_SIZE) {
            throw new IllegalArgumentException("[ERROR] 코치의 수는 2명 이상, 5명 이하입니다.");
        }
    }

    private static void validateCoachNameSize(List<Coach> coaches) {
        for (Coach coach : coaches) {
            int coachNameSize = coach.getName().length();

            if (coachNameSize < MIN_COACH_NAME_SIZE | coachNameSize > MAX_COACH_NAME_SIZE) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름 길이는 2글자 이상 4글자 이하입니다.");
            }
        }
    }
}
