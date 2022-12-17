package menu.view.validator;

import java.util.List;

public class Validator {

    public static final String DELIMITER = ",";
    private static final String COACH_NAME_DELIMITER_ERROR = "[ERROR] 코치 이름은 \",\"로 구분되어야 합니다.\n";
    private static final String COACH_SIZE_MINIMUM_ERROR = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다.\n";
    private static final String COACH_SIZE_MAXIMUM_ERROR = "[ERROR] 코치는 최대 5명 이하로 입력이 가능합니다.\n";
    private static final String COACH_NAME_FORMAT = "[가-힣]{2,4}";
    private static final String COACH_NAME_INVALID_FORMAT_ERROR = "[ERROR] 코치 이름 형식이 올바르지 않습니다.\n";
    private static final String HATE_MENU_MAXIMUM_ERROR = "[ERROR] 못 먹는 메뉴는 최대 2개 입력이 가능합니다.\n";
    private static final String DUPLICATION_ERROR = "[ERROR] 입력이 중복되었습니다.\n";
    private static final int COACH_MINIMUM_SIZE = 2;
    private static final int COACH_MAXIMUM_SIZE = 5;
    private static final int HATE_MENU_MAXIMUM_SIZE = 2;

    public void validateCoachNames(List<String> names) {
        validateCoachSize(names);
        validateCoachName(names);
        validateDuplication(names);
    }

    public void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(COACH_NAME_DELIMITER_ERROR);
        }
    }

    private void validateCoachSize(List<String> names) {
        int coachCount = names.size();
        if (coachCount < COACH_MINIMUM_SIZE) {
            throw new IllegalArgumentException(COACH_SIZE_MINIMUM_ERROR);
        }
        if (coachCount > COACH_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(COACH_SIZE_MAXIMUM_ERROR);
        }
    }

    private void validateCoachName(List<String> names) {
        for (String name : names) {
            if (!name.matches(COACH_NAME_FORMAT)) {
                throw new IllegalArgumentException(COACH_NAME_INVALID_FORMAT_ERROR);
            }
        }
    }

    public void validateHateMenus(List<String> menus) {
        validateMenuSize(menus);
        validateDuplication(menus);
    }

    private void validateMenuSize(List<String> names) {
        if (names.size() > HATE_MENU_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(HATE_MENU_MAXIMUM_ERROR);
        }
    }

    private void validateDuplication(List<String> names) {
        if (hasDuplication(names)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    private boolean hasDuplication(List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }
}
