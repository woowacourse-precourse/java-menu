package menu.view;

import menu.ErrorConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;

    public void validateReadCoachNames(String[] coachNames) {
        if (isWrongCoachNameLength(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치의 이름은 2글자 이상 4글자 이하여야합니다.");
        }
    }

    private boolean isWrongCoachNameLength(String[] coachNames) {
        long wrongCoachCount = Arrays.stream(coachNames)
                .map(Integer::parseInt)
                .filter(coachName -> coachName < MIN_COACH_NAME_LENGTH || coachName > MAX_COACH_NAME_LENGTH)
                .count();
        return wrongCoachCount != 0;
    }
}
