package menu.util;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String COACH_NAMES_ERROR_1 = "[ERROR] 코치는 최소 2명, 최대 5명까지입니다.";
    private static final String COACH_NAMES_ERROR_2 = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자까지입니다.";

    public static String validateCoachNames(String input) {
        List<String> coachNames = Arrays.asList(input.split(","));
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_1);
        }
        if (!isCoachNameSizeTwoToFour(coachNames)) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_2);
        }
        return input;
    }

    private static boolean isCoachNameSizeTwoToFour(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (coachName.length() < 2 || coachName.length() > 4) {
                return false;
            }
        }
        return true;
    }
}
