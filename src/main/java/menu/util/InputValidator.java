package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.message.ErrorMessage;

public class InputValidator {
    private InputValidator() {
    }


    public static List<String> validateCoach(final String inputCoach) {
        if (!isValidLength(inputCoach)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH);
        }
        return Arrays.stream(inputCoach.split(","))
                .collect(Collectors.toList());
    }

    private static boolean isValidLength(final String inputCoach) {
        return Arrays.stream(inputCoach.split(","))
                .map(String::length)
                .allMatch(length -> length >= 2 && length <= 4);
    }
}
