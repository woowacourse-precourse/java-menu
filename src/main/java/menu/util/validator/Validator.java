package menu.util.validator;

import java.util.regex.Pattern;
import menu.util.ExceptionMessage;

public abstract class Validator {

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    abstract void validate(String input) throws IllegalArgumentException;

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage(), exception);
        }
    }

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < Range.MIN_RANGE.value || number > Range.MAX_RANGE.value) {
            throw new IllegalArgumentException();
        }
    }

    private enum Range {
        MIN_RANGE(3), MAX_RANGE(20);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}
