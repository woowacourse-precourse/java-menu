package menu.utils;

import java.util.List;
import menu.domain.repository.MenuRepository;

public class Validation {

    private static final int COACH_MIN_SIZE = 2;
    private static final int COACH_MAX_SIZE = 5;
    private static final int CANT_EAT_MENU_MIN_SIZE = 0;
    private static final int CANT_EAT_MENU_MAX_SIZE = 2;
    private static final int COACH_NAME_MIN_SIZE = 2;
    private static final int COACH_NAME_MAX_SIZE = 4;

    public static void isCoachNames(String target) {
        isInCoachSize(target);
    }

    public static void isCantEatMenus(String target) {
        isInCantEatMenuSize(target);
    }

    public static void isCoachName(String target) {
        String[] name = target.split("");
        isNotSmallerThanMinSize(name, COACH_NAME_MIN_SIZE);
        isNotBiggerThanMaxSize(name, COACH_NAME_MAX_SIZE);
    }

    public static void isMenus(List<String> menuNames) {
        for (String menuName : menuNames) {
            isKorean(menuName);
            isExistedMenu(menuName);
        }
    }

    private static void isExistedMenu(String menuName) {
        MenuRepository.isExistMenuByName(menuName);
    }

    private static void isInCoachSize(String target) {
        String[] coachs = target.split(",");
        isNotSmallerThanMinSize(coachs, COACH_MIN_SIZE);
        isNotBiggerThanMaxSize(coachs, COACH_MAX_SIZE);
    }

    private static void isInCantEatMenuSize(String target) {
        String[] menus = target.split(",");
        isNotKoreans(menus);
        isNotSmallerThanMinSize(menus, CANT_EAT_MENU_MIN_SIZE);
        isNotBiggerThanMaxSize(menus, CANT_EAT_MENU_MAX_SIZE);
    }

    private static void isNotSmallerThanMinSize(String[] targets, int minSize) {
        if (targets.length < minSize) {
            throw new IllegalArgumentException(ExceptionType.IS_LOWER_THAN_SIZE.toString());
        }
    }

    private static void isNotBiggerThanMaxSize(String[] targets, int maxSize) {
        if (targets.length > maxSize) {
            throw new IllegalArgumentException(ExceptionType.IS_BIGGER_THAN_SIZE.toString());
        }
    }

    private static void isNotKoreans(String[] menus) {
        for (String menu : menus) {
            isKorean(menu);
        }
    }

    private static void isKorean(String target) {
        String koreanRegex = "^[가-힣]*$";
        if (!target.matches(koreanRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_KOREAN.toString());
        }
    }
}
