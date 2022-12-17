package menu.util;

import menu.constant.ExceptionConstants;

import java.util.List;

public class Validator {

    public static void validateLowerBound(int number, int lowerBound, ExceptionConstants exception) {
        if (number < lowerBound) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateUpperBound(int number, int upperBound, ExceptionConstants exception) {
        if (number > upperBound) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateDuplication(List<String> input) {
        if (input.size() != input.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(ExceptionConstants.DUPLICATION.getMessage());
        }
    }
}
