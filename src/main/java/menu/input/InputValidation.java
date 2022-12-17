package menu.input;

import menu.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidation {
    public static final int COACH_NAME_MAX_LENGTH = 4;
    public static final int COACH_NAME_MIN_LENGTH = 2;
    public static final int COACH_MAX_NUMBER = 5;
    public static final int COACH_MIN_NUMBER = 2;

    public static final int NOT_EAT_MENU_MAX_NUMBER = 2;
    public static final int NOT_EAT_MENU_MIN_NUMBER = 0;

    public static void validateReadCoaches(String coaches) {
        List<String> coach = new ArrayList<>(Arrays.asList(coaches.split(InputView.splitString)));

        validateLengthOfName(coach);
        validateNumberOfCoach(coach);
    }

    private static void validateLengthOfName(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.length() > COACH_NAME_MAX_LENGTH || coach.length() < COACH_NAME_MIN_LENGTH) {
                ErrorMessage.printCoachNameLengthError();
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateNumberOfCoach(List<String> coaches) {
        int coachSize = coaches.size();
        if(coachSize > COACH_MAX_NUMBER || coachSize < COACH_MIN_NUMBER) {
            ErrorMessage.printCoachNumberError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateReadNotEatMenus(String menus) {
        List<String> menu = new ArrayList<>(Arrays.asList(menus.split(InputView.splitString)));
        validateNumberOfNotEatMenus(menu);
    }

    private static void validateNumberOfNotEatMenus(List<String> menus) {
        int menuSize = menus.size();
        if(menuSize > NOT_EAT_MENU_MAX_NUMBER || menuSize < NOT_EAT_MENU_MIN_NUMBER) {
            ErrorMessage.printNotEatMenusError();
            throw new IllegalArgumentException();
        }
    }
}
