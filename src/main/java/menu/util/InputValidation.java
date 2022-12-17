package menu.util;

import menu.domain.CoachCondition;

import static menu.constant.ExceptionMessage.WRONG_COACH_COUNT;
import static menu.constant.ExceptionMessage.WRONG_COACH_NAME_LENGTH;
import static menu.domain.CoachCondition.*;

public class InputValidation {

    public String[] validateCoach(String userInput) {
        String[] coachNames = validateCoachCount(userInput);
        for (String coachName : coachNames) {
            validateCoachName(coachName);
        }
        return coachNames;
    }

    private void validateCoachName(String coachName) {
        if(!CoachCondition.validCoachNameLength(coachName)) {
            throw new IllegalArgumentException(String.format(WRONG_COACH_NAME_LENGTH.getValue(), MIN_COACH_NAME_LENGTH.getValue(), NAX_COACH_NAME_LENGTH.getValue()));
        }
    }

    private String[] validateCoachCount(String userInput) {
        String[] coachNames = userInput.split(",");
        if(!CoachCondition.validCoachCount(coachNames)) {
            throw new IllegalArgumentException(String.format(WRONG_COACH_COUNT.getValue(), MIN_COACH_COUNT.getValue(), MAX_COACH_COUNT.getValue()));
        }
        return coachNames;
    }
}
