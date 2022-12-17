package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.message.ErrorMessage;

public class InputValidator {

    public static final int MIN_COACH = 2;
    public static final int MAX_COACH = 5;
    public static final int MIN_NAME = 2;
    public static final int MAX_NAME = 4;

    private InputValidator() {
    }


    public static List<String> validateCoach(final String inputCoach) {
        if (!isValidCoachCount(inputCoach)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_COUNT);
        }
        if (!isValidLength(inputCoach)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH);
        }
        if (isDuplicate(inputCoach)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_COACH_NAME);
        }
        return Arrays.stream(inputCoach.split(","))
                .collect(Collectors.toList());
    }

    private static boolean isDuplicate(final String inputCoach) {
        int count  = (int) Arrays.stream(inputCoach.split(",")).count();
        return count != (int) Arrays.stream(inputCoach.split(","))
                .distinct()
                .count();
    }

    private static boolean isValidCoachCount(final String inputCoach) {
        int count = (int) Arrays.stream(inputCoach.split(","))
                .count();
        return count >= MIN_COACH && count <= MAX_COACH;
    }

    private static boolean isValidLength(final String inputCoach) {
        return Arrays.stream(inputCoach.split(","))
                .map(String::length)
                .allMatch(length -> length >= MIN_NAME && length <= MAX_NAME);
    }
}
