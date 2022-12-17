package menu.valid;

import static menu.util.NumberProperty.MAX_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MAX_COACH_NUMBER;
import static menu.util.NumberProperty.MIN_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MIN_COACH_NUMBER;

public class InputValidator {

    public static void validateCoachName(String input) {
        String[] names = input.split(",");
        validateNumberOfCoach(names);
        validateCoachNameLength(names);
    }

    private static void validateNumberOfCoach(String[] names) {
        if (names.length < MIN_COACH_NUMBER || names.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.");
        }
    }

}
