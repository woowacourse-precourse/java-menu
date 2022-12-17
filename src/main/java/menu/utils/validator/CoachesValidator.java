package menu.utils.validator;

import static menu.utils.Constants.ERROR_COACHNAME_LENGTH;
import static menu.utils.Constants.ERROR_COACHNUMBER;

import java.util.List;

public class CoachesValidator {

    private final List<String> coaches;

    public CoachesValidator(List<String> coaches) {
        this.coaches = coaches;
        coachNumberValidator(coaches);
    }

    private void coachNumberValidator(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(ERROR_COACHNUMBER);
        }
    }
}
