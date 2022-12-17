package menu.view;

import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;

public class InputValidator {

    private static final String ERROR_COACH_COUNT ="[ERROR] 코치는 최소 2명 최대 5명까지 가능합니다.";
    private static final String ERROR_COACH_NAME_LENGTH = "[ERROR] 코치의 이름은 최소 2글자 최대 4글자까지 입력 가능합니다.";
    private static final String ERROR_MENU_COUNT = "[ERROR] 메뉴 갯수는 2개까지 입력 가능합니다.";
    private static final String ERROR_MENU_KOREAN = "[ERROR] 메뉴 이름은 한글로만 입력해주세요.";

    public static void validateCoach(String input) {
        String[] coachNames = input.split("\\s*,\\s*");
        validateCoachCount(coachNames.length);
        for (String coachName : coachNames) {
            validateNameLength(coachName);
        }
    }

    private static void validateCoachCount(int count) {
        if (!(count >= 2 && count <= 5)) {
            throw new IllegalArgumentException(ERROR_COACH_COUNT);
        }
    }

    private static void validateNameLength(String coachName) {
        if (!(coachName.length() >= 2 && coachName.length() <= 4)) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH);
        }
    }

    public static void validateUnavailableMenus(String input) {
        String[] menus = input.split("\\s*,\\s*");
        validateMenuCount(menus.length);
        for (String menu : menus) {
            validateKorean(menu);
        }
    }

    private static void validateMenuCount(int count) {
        if (count > 2) {
            throw new IllegalArgumentException(ERROR_MENU_COUNT);
        }
    }

    private static void validateKorean(String menu) {
        if (!menu.matches("[가-힣]*")) {
            throw new IllegalArgumentException(ERROR_MENU_KOREAN);
        }
    }
}
