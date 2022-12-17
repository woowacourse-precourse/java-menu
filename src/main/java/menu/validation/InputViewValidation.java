package menu.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static menu.constant.ErrorConstant.*;

public class InputViewValidation {

    public static List<String> checkCoachInputValid(String coachInput) {
        String[] coachInfo = coachInput.split(",");
        checkCoachInfoCount(coachInfo);
        checkEachCoachInfo(coachInfo);
        return Arrays.asList(coachInfo);
    }

    private static void checkCoachInfoCount(String[] coachInfo) {
        if (coachInfo.length <2 || coachInfo.length >5) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COACH_COUNT);
        }
    }

    private static void checkEachCoachInfo(String[] coachInfo) {
        checkDuplicateCoachInfo(coachInfo);
        for (String coachName : coachInfo) {
            if (coachName.length() < 2 || coachName.length() > 4) {
                throw new IllegalArgumentException(ERROR_NOT_VALID_NAME_COUNT);
            }
        }
    }

    private static void checkDuplicateCoachInfo(String[] coachInfo) {
        Set<String> set = new HashSet<>(Arrays.asList(coachInfo));
        if (set.size() != coachInfo.length) {
            throw new IllegalArgumentException(ERROR_COACH_DUPLICATE);
        }
    }

    public static List<String> checkDislikeFoodValid(String dislikeFood) {
        String[] dislikeFoodInfo = dislikeFood.split(",");
        checkDislikeFoodInfoCount(dislikeFoodInfo);
        return Arrays.asList(dislikeFoodInfo);
    }

    private static void checkDislikeFoodInfoCount(String[] dislikeFoodInfo) {
        if (dislikeFoodInfo.length >2) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_DISLIKE_FOOD_COUNT);
        }
    }
}
