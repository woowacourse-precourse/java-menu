package menu.utils;

import java.util.Arrays;

public class Validation {
    public static int CHECK_COACHES_NUMBER = 1;
    public static int CHECK_MENU_NUMBER = 2;
    private static int MAX_COACHE_NAME = 5;
    private static int MIN_COACHE_NAME = 2;
    private static int MAX_COACHE_SIZE = 5;
    private static int MIN_COACHE_SIZE = 2;
    private static int MAX_EATABLE_SIZE = 2;

    public static void checkValidNotEatable(String[] input) {
        validNotEatableSize(input);
        validElementDuplicate(input, Validation.CHECK_MENU_NUMBER);
        validMenuIsExist(input);
    }

    public static void checkValidCoaches(String[] input) {
        validCoachesNameSize(input);
        validElementDuplicate(input, Validation.CHECK_COACHES_NUMBER);
        for (String name : input) {
            validCoachNameSize(name.trim());
        }
    }
    private static void validCoachNameSize(String name) {
        if (name.length() < MIN_COACHE_NAME || name.length() > MAX_COACHE_NAME) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_SIZE_IS_BETWEEN_TWO_AND_FOUR);
        }
    }

    private static void validCoachesNameSize(String[] names) {
        if (names.length < MIN_COACHE_SIZE || names.length > MAX_COACHE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.COACH_IS_LEAST_TWO_AND_MAX_FIVE);
        }
    }

    private static void validElementDuplicate(String[] names, int checkNumber) {
        long originalLength = names.length;
        long distinctLength = Arrays.stream(names).distinct().count();

        if (originalLength != distinctLength) {
            if (checkNumber == CHECK_COACHES_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_IS_NOT_DUPLICATE);
            }
            if (checkNumber == CHECK_MENU_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NOT_MENU_NAME_DUPLICATE);
            }
        }
    }

    private static void validNotEatableSize(String[] input) {
        if (input.length > MAX_EATABLE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EATABLE_MENU_SIZE_IS_LESS_THAN_TWO);
        }
    }

    private static void validMenuIsExist(String[] input) {
        for (String name : input) {
            if (Menu.valueOfMenu(name) == null && !name.trim().isBlank())
                throw new IllegalArgumentException(ErrorMessage.MENU_IS_NOT_EXIST_IS_LIST);
        }
    }
}
