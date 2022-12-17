package util;

import java.util.Arrays;
import java.util.List;

import constant.ErrorLog;
import domain.Menus;

public class Validator {
    private final static int MIN_NAME_LENGTH = 2;
    private final static int MAX_NAME_LENGTH = 4;
    private final static int MIN_COACH_NUMBER = 2;
    private final static int MAX_COACH_NUMBER = 5;
    private final static String EMPTY = "";
    private final static int MAX_NUMBER_OF_INEDIBLE_MENU = 2;
    private final static int MAX_NUMBER_OF_REPETITION_LIMIT_OF_CATEGORY = 2;

    public static void validateCoach(List<String> coachNames) {
        validateCoachNumber(coachNames);
        validateCoachName(coachNames);
        validateNoDuplication(coachNames);
    }

    private static void validateCoachName(List<String> coachNames) {
        coachNames.forEach(name -> {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorLog.INVALID_NAME.getLog());
            }
        });
    }

    private static void validateCoachNumber(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_NUMBER || coachNames.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(ErrorLog.INVALID_COACH_NUMBER.getLog());
        }
    }

    private static void validateNoDuplication(List<String> coachNames) {
        int size = coachNames.size();
        if (coachNames.stream().distinct().count() != size) {
            throw new IllegalArgumentException(ErrorLog.DUPLICATION.getLog());
        }
    }

    public static void validateMenus(List<String> inedibleMenus) {
        validateMenuSize(inedibleMenus);
        validateMenuInOrigin(inedibleMenus);
    }

    private static void validateMenuSize(List<String> inedibleMenus) {
        if (inedibleMenus.size() > MAX_NUMBER_OF_INEDIBLE_MENU) {
            throw new IllegalArgumentException(ErrorLog.INVALID_MENU_SIZE.getLog());
        }
    }

    private static void validateMenuInOrigin(List<String> inedibleMenus) {
        inedibleMenus.forEach(
            menu -> {
                if (Arrays.stream(Menus.values()).noneMatch(category -> category.getMenus().contains(menu))
                    && !menu.equals(EMPTY)) {
                    throw new IllegalArgumentException(ErrorLog.NO_MENU.getLog());
                }
            });
    }

    public static void validateCategories(List<String> selectedCategories) {
        for (String category : selectedCategories) {
            if (selectedCategories.stream().filter(x -> x.equals(category)).count()
                > MAX_NUMBER_OF_REPETITION_LIMIT_OF_CATEGORY) {
                throw new IllegalArgumentException(ErrorLog.INVALID_CATEGORY_SELECTION.getLog());
            }
        }
    }
}
