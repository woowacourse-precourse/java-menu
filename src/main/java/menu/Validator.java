package menu;

import java.util.List;

import static menu.utils.Constant.*;
import static menu.utils.ErrorMessage.*;

public class Validator {
    public List<String> validateSeparator(String input) {
        try {
            return List.of(input.split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException(SEPARATOR_ERROR.getErrorMessage());
        }
    }

    public void validateCoachNumRange(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_NUM) {
            throw new IllegalArgumentException(MIN_COACH_NUM_ERROR
                    .getErrorMessage(MIN_COACH_NUM));
        }

        if (coachNames.size() > MAX_COACH_NUM) {
            throw new IllegalArgumentException(MAX_COACH_NUM_ERROR
                    .getErrorMessage(MAX_COACH_NUM));
        }
    }

    public void validateCoachNameLength(List<String> coachNames) {
        for (String name : coachNames) {
            if (name.length() < MIN_COACH_NAME_LENGTH) {
                throw new IllegalArgumentException(MIN_COACH_NAME_LENGTH_ERROR
                        .getErrorMessage(MIN_COACH_NAME_LENGTH));
            }
            if (name.length() > MAX_COACH_NAME_LENGTH) {
                throw new IllegalArgumentException(MAX_COACH_NAME_LENGTH_ERROR
                        .getErrorMessage(MAX_COACH_NAME_LENGTH));
            }
        }
    }

    public void validateMenuNum(List<String> menus) {
        if (menus.size() > MAX_MENU_NUM) {
            throw new IllegalArgumentException(MAX_HATE_MENU_NUM_ERROR
                    .getErrorMessage(MAX_MENU_NUM));
        }
    }
}
