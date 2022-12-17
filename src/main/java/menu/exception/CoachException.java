package menu.exception;

import menu.utils.Converter;

import java.util.List;

public class CoachException extends CommonException {

    private final Converter converter;

    public CoachException(Converter converter) {
        this.converter = converter;
    }

    @Override
    public void verifyException(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkSeperatedByComma(input, 1, 4);

        List<String> names = converter.convertToList(input);
        checkNameLength(names);
        checkCoachCount(names);
    }

    private void checkNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ExceptionCode.NOT_CORRECT_COACH_NAME.getMessage());
            }
        }
    }

    private void checkCoachCount(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(ExceptionCode.OUT_OF_RANGE_COACH_COUNT.getMessage());
        }
    }
}
