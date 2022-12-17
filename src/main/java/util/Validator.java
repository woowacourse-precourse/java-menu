package util;

import java.util.Arrays;
import java.util.List;

import constant.ErrorLog;
import domain.Menus;

public class Validator {

    public static void validateCoach(List<String> coachNames) {
        validateCoachNumber(coachNames);
        validateCoachName(coachNames);
        validateNoDuplication(coachNames);
    }

    private static void validateCoachName(List<String> coachNames) {
        coachNames.forEach(name -> {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ErrorLog.INVALID_NAME.getLog());
            }
        });
    }

    private static void validateCoachNumber(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
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
        if (inedibleMenus.size() > 2) {
            throw new IllegalArgumentException(ErrorLog.INVALID_MENU_SIZE.getLog());
        }
    }

    private static void validateMenuInOrigin(List<String> inedibleMenus) {
        inedibleMenus.forEach(
            menu -> {
                if (Arrays.stream(Menus.values()).noneMatch(category -> category.getMenus().contains(menu)) && !menu.equals("")) {
                    throw new IllegalArgumentException(ErrorLog.NO_MENU.getLog());
                }
            });
    }
}
