package menu.utils;

public class Validator {

    private static final int MIN_COACH = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_COACH_NAME = 5;
    private static final int MAX_DISLIKE_MENU = 5;

    public static void isCorrectName(String input) {
        String[] names = input.split("\\s*,\\s*");
        int length = names.length;
        if (length < MIN_COACH) {
            throw new IllegalArgumentException(ErrorMessage.COACH_MIN_COUNT_ERROR.toString());
        }
        if ((length > MAX_COACH_COUNT)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_ERROR.toString());
        }
        for (String name : names) {
            if (!(name.length() >= MIN_COACH && name.length() <= MAX_COACH_NAME)) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_ERROR.toString());
            }
        }
    }

}
