package menu.utls;

import menu.message.ErrorMessage;

public class Validator {
    private static final String DELIMITER = ",";
    private static final int COACH_MIN_LENGTH = 2;
    private static final int COACH_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;

    public void validateCoachNames(String input) {
        String[] names = input.split(DELIMITER);
        int length = names.length;
        checkCoachLength(length);
        checkNameLength(names);
    }

    private void checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_COACH_NAMES);
            }
        }
    }

    private void checkCoachLength(int length) {
        if (length < COACH_MIN_LENGTH || length > COACH_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_COACH_NAMES);
        }
    }
}
