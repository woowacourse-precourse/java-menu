package menu.util;

public class Validator {

    private static final String COACH_NUMBER_ERROR = "코치 인원은 최소 2명 최대 5명까지 가능합니다.";

    private static final String COACH_NAME_LENGTH_ERROR = "코치 이름은 최소 2글자 최대 4글자이여야합니다.";

    public static void checkCoachNames(String input) {
        checkCoachNumber(input);
        checkCoachNameLength(input);
    }

    private static void checkCoachNameLength(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR);
            }
        }
    }

    private static void checkCoachNumber(String input) {
        int length = input.split(",").length;
        if (length < 2 || length > 5) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR);
        }
    }
}
