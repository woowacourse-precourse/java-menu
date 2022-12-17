package menu.utils;

import java.util.regex.Pattern;

public class Validator {

    private static final int MIN_COACH = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_COACH_NAME = 5;
    private static final int MIN_DISLIKE_MENU = 2;
    private static final String KOREA_ALPHABET = "^[가-힣\\s]*$";

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

    public static void isCorrectMenuCount(String input) {
        if (!input.contains(",") && input.matches(KOREA_ALPHABET)) {
            return;
        }
        String[] menus = input.split("\\s*,\\s*");
        if (menus.length > MIN_DISLIKE_MENU) {
            throw new IllegalArgumentException(ErrorMessage.DISLIKE_MENU_ERROR.toString());
        }
        for (String menu : menus) {
            if (!menu.matches(KOREA_ALPHABET)) {
                throw new IllegalArgumentException(ErrorMessage.DISLIKE_MENU_ERROR.toString());
            }
        }
    }

}
