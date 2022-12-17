package menu.utils.validator;

import static menu.utils.Constants.ERROR_COACHNAME_LENGTH;
import static menu.utils.Constants.ERROR_COACHNUMBER;

import java.util.List;

public class CoachValidator {

    private final List<String> coaches;

    public CoachValidator(List<String> coaches) {
        this.coaches = coaches;
        coachNumberValidator(coaches);
        coachNameValidator(coaches);
    }

    private void coachNumberValidator(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(ERROR_COACHNUMBER);
        }
    }

    private void coachNameValidator(List<String> coaches) {
        for (String name : coaches) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ERROR_COACHNAME_LENGTH);
            }
        }
    }
}
