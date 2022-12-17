package menu.validator;

import static menu.validator.BaseValidator.verifyNameDistinction;

import java.util.List;
import menu.exception.coach.CoachNameDuplicationException;
import menu.exception.coach.WrongCoachNameException;
import menu.exception.coach.WrongCoachNumberException;

public class CoachValidator {

    public static final int COACH_MIN_NUM = 2;
    public static final int COACH_MAX_NUM = 5;
    public static final int COACH_NAME_MIN_LENGTH = 2;
    public static final int COACH_NAME_MAX_LENGTH = 4;


    public static void validateCoach(List<String> coachNames) {
        if (!verifyCoachNumber(coachNames)) {
            throw new WrongCoachNumberException();
        }
        if (!verifyNameDistinction(coachNames)) {
            throw new CoachNameDuplicationException();
        }
    }

    public static void validateCoachName(String name) {
        if (!verifyNameLength(name)) {
            throw new WrongCoachNameException();
        }
    }

    private static boolean verifyCoachNumber(List<String> coachNames) {
        return coachNames.size() >= COACH_MIN_NUM && coachNames.size() <= COACH_MAX_NUM;
    }

    private static boolean verifyNameLength(String name) {
        return name.length() >= COACH_NAME_MIN_LENGTH && name.length() <= COACH_NAME_MAX_LENGTH;
    }
}
