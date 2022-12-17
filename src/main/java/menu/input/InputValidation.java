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
}
