package menu.validation;

import java.util.List;

public class Validation {

    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;
    private static final String ERROR_COACH_NAME_LENGTH = "[ERROR] 코치의 이름은 최소2글자 최대 4글자여야 합니다.";


    public static void validateCoachNameLength(List<String> coachName) {
        boolean checkNameLength = coachName.stream()
            .allMatch(name -> NAME_MIN_LENGTH <= name.length() && name.length() <= NAME_MAX_LENGTH);
        if(!checkNameLength) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH);
        }
    }
}
