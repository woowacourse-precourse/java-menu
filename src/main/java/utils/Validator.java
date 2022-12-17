package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String DELIMITER = ",";
    private static final String INVALID_COACH_COUNT_OUTPUT_MESSAGE = "코치는 최소 2명 ~ 최대 5명 입력해야합니다.";
    private static final String INVALID_COACH_NAME_OUTPUT_MESSAGE = "코치 이름은 최소 2글자 ~ 최대 5글자로 입력해야합니다.";

    public static boolean isValidCoachNames(String coachNames) {
        List<String> coaches = splitter(coachNames);

        return isValidCoachNameLetterCount(coaches) && isValidCoachCount(coaches);
    }

    private static boolean isValidCoachNameLetterCount(List<String> coaches) {
        try {
            checkValidCoachLetterCount(coaches);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return true;
        }

        return false;
    }

    private static void checkValidCoachLetterCount(List<String> coaches) {
        boolean isOverTwoLetter = coaches.stream().allMatch(name -> name.length() > 1);
        boolean isUnderSixLetter = coaches.stream().allMatch(name -> name.length() < 6);

        if (!isOverTwoLetter || !isUnderSixLetter) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_OUTPUT_MESSAGE);
        }
    }

    private static boolean isValidCoachCount(List<String> coaches) {
        try {
            checkValidCoachCount(coaches);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return true;
        }

        return false;
    }

    private static void checkValidCoachCount(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT_OUTPUT_MESSAGE);
        }
    }

    private static List<String> splitter(String coachNames) {
        return Arrays.stream(coachNames.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
