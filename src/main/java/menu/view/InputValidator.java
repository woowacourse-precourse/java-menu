package menu.view;

import menu.ErrorConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;

    public void validateReadCoachNames(List<String> coachNames) {
        if (isWrongCoachNameLength(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치의 이름은 2글자 이상 4글자 이하여야합니다.");
        }
        if (isWrongCoachCount(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치는 최소 2명에서 최대 5명이어야합니다.");
        }
    }

    private boolean isWrongCoachNameLength(List<String> coachNames) {
        long wrongCoachCount = coachNames.stream()
                .map(Integer::parseInt)
                .filter(coachName -> coachName < MIN_COACH_NAME_LENGTH || coachName > MAX_COACH_NAME_LENGTH)
                .count();
        return wrongCoachCount != 0;
    }

    private boolean isWrongCoachCount(List<String> coachNames) {
        int coachCount = coachNames.size();
        return coachCount < MIN_COACH_COUNT || coachCount > MAX_COACH_COUNT;
    }
}
