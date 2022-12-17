package menu.valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static menu.util.NumberProperty.MAX_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MAX_COACH_NUMBER;
import static menu.util.NumberProperty.MIN_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MIN_COACH_NUMBER;
import static menu.util.message.ErrorMessage.DUPLICATED_COACH_NAME;

public class InputValidator {

    public static List<String> validateCoachName(String input) {
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNumberOfCoach(names);
        validateCoachNameLength(names);
        validateDuplicatedCoachName(names);
        return names;
    }

    private static void validateDuplicatedCoachName(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (Collections.frequency(names, names.get(i)) > 1) {
                throw new IllegalArgumentException(String.valueOf(DUPLICATED_COACH_NAME));
            }
        }
    }

    private static void validateNumberOfCoach(List<String> names) {
        if (names.size() < MIN_COACH_NUMBER || names.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.");
        }
    }

    private static void validateCoachNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
            }
        }
    }
}
