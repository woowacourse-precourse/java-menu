package menu.util.validator;

import menu.util.ExceptionMessage;

public class CoachNameValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNameLength(input);
    }

    void validateNameLength(String input) {
        int nameLength = input.length();
        if (nameLength <= Range.MIN_RANGE.value || nameLength >= Range.MAX_RANGE.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    private enum Range {
        MIN_RANGE(1), MAX_RANGE(5);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}
