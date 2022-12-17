package menu.utils.validator;

import static menu.utils.Constants.ERROR_COACHNAME_LENGTH;

import java.util.List;

public class CoachValidator {

    private final String coach;

    public CoachValidator(String coach) {
        this.coach = coach;
        coachNameValidator(coach);
    }

    private void coachNameValidator(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ERROR_COACHNAME_LENGTH);
        }
    }
}
