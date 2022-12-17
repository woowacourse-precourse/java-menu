package menu.exception;

import java.util.List;

public class CoachException extends CommonException {

    @Override
    public void verifyException(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkSeperatedByComma(input, 1, 4);
    }

    private void checkNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ExceptionCode.NOT_CORRECT_COACH_NAME.getMessage());
            }
        }
    }
}
