package menu.valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static menu.util.NumberProperty.MAX_CANNOT_EAT_MENU_NUMBER;
import static menu.util.NumberProperty.MAX_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MAX_COACH_NUMBER;
import static menu.util.NumberProperty.MIN_COACH_NAME_LENGTH;
import static menu.util.NumberProperty.MIN_COACH_NUMBER;
import static menu.util.message.ErrorMessage.CANNOT_EAT_MENU_OUT_OF_SCOPE;
import static menu.util.message.ErrorMessage.COACH_NAME_OUT_OF_SCOPE;
import static menu.util.message.ErrorMessage.COACH_NUMBER_OUT_OF_SCOPE;
import static menu.util.message.ErrorMessage.DUPLICATED_COACH_NAME;

public class InputValidator {

    public static List<String> validateCoachName(String input) {
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNumberOfCoach(names);
        validateCoachNameLength(names);
        validateDuplicatedCoachName(names);
        return names;
    }

    private static void validateDuplicatedCoachName(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (Collections.frequency(names, names.get(i)) > 1) {
                throw new IllegalArgumentException(DUPLICATED_COACH_NAME.get());
            }
        }
    }

    private static void validateNumberOfCoach(List<String> names) {
        if (names.size() < MIN_COACH_NUMBER || names.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(COACH_NUMBER_OUT_OF_SCOPE.get());
        }
    }

    private static void validateCoachNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
                throw new IllegalArgumentException(COACH_NAME_OUT_OF_SCOPE.get());
            }
        }
    }

    public static List<String> validateCannotEatMenu(String input){
        if(isEmpty(input)){
            return new ArrayList<>();
        }
        List<String> cannotEatMenu = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNumberOfCannotEatMenu(cannotEatMenu);
        return cannotEatMenu;
    }

    private static void validateNumberOfCannotEatMenu(List<String> cannotEatMenu) {
        if (cannotEatMenu.size() > MAX_CANNOT_EAT_MENU_NUMBER) {
            throw new IllegalArgumentException(CANNOT_EAT_MENU_OUT_OF_SCOPE.get());
        }
    }

    private static boolean isEmpty(String input) {
        if(input.equals("")){
            return true;
        }
        return false;
    }
}
