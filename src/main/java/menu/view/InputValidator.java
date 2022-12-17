package menu.view;

import menu.ErrorConstants;
import menu.model.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_CANNOT_EAT_FOODS_COUNT = 2;

    public void validateReadCoachNames(List<String> coachNames) {
        if (isWrongCoachNameLength(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치의 이름은 2글자 이상 4글자 이하여야합니다.");
        }
        if (isWrongCoachCount(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치는 최소 2명에서 최대 5명이어야합니다.");
        }
        if (isDuplicateCoachName(coachNames)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "코치 이름은 중복되지 않게 입력해주세요.");
        }
    }

    private boolean isWrongCoachNameLength(List<String> coachNames) {
        long wrongCoachCount = coachNames.stream()
                .filter(coachName -> coachName.length() < MIN_COACH_NAME_LENGTH ||
                        coachName.length() > MAX_COACH_NAME_LENGTH)
                .count();
        return wrongCoachCount != 0;
    }

    private boolean isWrongCoachCount(List<String> coachNames) {
        int coachCount = coachNames.size();
        return coachCount < MIN_COACH_COUNT || coachCount > MAX_COACH_COUNT;
    }

    private boolean isDuplicateCoachName(List<String> coachNames) {
        int beforeSize = coachNames.size();
        List<String> distinctCoachNames = coachNames.stream()
                .distinct()
                .collect(Collectors.toList());
        int afterSize = distinctCoachNames.size();
        return beforeSize != afterSize;
    }

    public void validateReadCannotEatFoods(List<String> cannotEatFoods) {
        if (!cannotEatFoods.isEmpty()) {
            if (isNotExistFoods(cannotEatFoods)) {
                throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "등록된 메뉴에 해당 메뉴가 없습니다.");
            }
            if (isFoodCountOverTwo(cannotEatFoods)) {
                throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "못 먹는 메뉴는 최대 2개여야합니다.");
            }
        }
    }

    private boolean isNotExistFoods(List<String> cannotEatFoods) {
        long notExistCount = cannotEatFoods.stream()
                .filter(Category::isNotExistMenu)
                .count();

        return notExistCount != 0;
    }

    private boolean isFoodCountOverTwo(List<String> cannotEatFoods) {
        return cannotEatFoods.size() > MAX_CANNOT_EAT_FOODS_COUNT;
    }
}
