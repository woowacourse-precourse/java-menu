package exception;

import java.util.List;

public class CoachException {
    private static final int MINIMUM_COACHES = 2;
    private static final int MAXIMUM_COACH_SIZE = 5;

    public static void validate(List<String> names) {
        validateMaximumSize(names);
        validateMinimumSize(names);
    }

    private static void validateMaximumSize(List<String> names) {
        if (names.size() > MAXIMUM_COACH_SIZE) {
            throw new IllegalArgumentException("코치는 최소 5명 이하로 입력해야 합니다.");
        }
    }

    private static void validateMinimumSize(List<String> names) {
        if (names.size() < MINIMUM_COACHES) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
    }
}
