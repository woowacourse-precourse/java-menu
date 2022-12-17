package menu.view;

public class Validator {
    private static final String INVALID_NUMBER_COACH_NAME = "[ERROR] 코치는 최소 2명 이상 최대 5명 이하로 입력해야 합니다.";
    private static final String INVALID_LENGTH_COACH_NAME = "[ERROR] 코치는 최소 2명 이상 최대 5명 이하로 입력해야 합니다.";
    public static void validateCoachName(String[] names) {
        validateCoachNameNumber(names);
        validateCoachNameLength(names);
    }

    private static void validateCoachNameNumber(String[] names) {
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException(INVALID_NUMBER_COACH_NAME);
        }
    }

    private static void validateCoachNameLength(String[] names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(INVALID_LENGTH_COACH_NAME);
            }
        }
    }

    public static void validateFoodName(String[] names) {
        validateFoodNameNumber(names);
    }

    private static void validateFoodNameNumber(String[] names) {
        if (2 < names.length) {
            throw new IllegalArgumentException(INVALID_NUMBER_COACH_NAME);
        }
    }
}
