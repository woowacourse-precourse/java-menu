package menu.view;

import org.junit.jupiter.params.ParameterizedTest;

public class InputValidator {

    private static final String ERROR_COACH_COUNT_MIN ="[ERROR] 코치는 최소 2명 이상 입력해야 합니다.";
    private static final String ERROR_COACH_COUNT_MAX ="[ERROR] 코치는 최대 5명까지 가능합니다.";
    private static final String ERROR_COACH_NAME_LENGTH_MIN = "[ERROR] 코치의 이름은 최소 2글자 이상 입력해야 합니다.";
    private static final String ERROR_COACH_NAME_LENGTH_MAX = "[ERROR] 코치의 이름은 최대 4글자까지 입력 가능합니다.";

    public static void validateCoach(String input) {
        String[] coachNames = input.split("\\s,\\s");
        validateCoachCount(coachNames.length);
        for (String coachName : coachNames) {
            validateNameLength(coachName);
        }
    }

    private static void validateCoachCount(int count) {
        if (count < 2) {
            throw new IllegalArgumentException(ERROR_COACH_COUNT_MIN);
        }
        if (count > 5) {
            throw new IllegalArgumentException(ERROR_COACH_COUNT_MAX);
        }
    }

    private static void validateNameLength(String coachName) {
        if (coachName.length() < 2) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH_MIN);
        }
        if (coachName.length() > 4) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH_MAX);
        }
    }
}
