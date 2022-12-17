package util;

import java.util.List;

import constant.ErrorLog;
import domain.Coach;

public class Validator {

    public static void validateCoachName(List<String> coachNames) {
        coachNames.forEach(name -> {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ErrorLog.INVALID_NAME.getLog());
            }
        });
    }

    public static void validateCoachNumber(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(ErrorLog.INVALID_COACH_NUMBER.getLog());
        }
    }

    public static void validateNoDuplication(List<String> coachNames) {
        int size = coachNames.size();
        if (coachNames.stream().distinct().count() != size) {
            throw new IllegalArgumentException(ErrorLog.DUPLICATION.getLog());
        }
    }
}
