package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int COACHES_SIZE_LOWER_BOUND = 2;
    private static final int COACHES_SIZE_UPPER_BOUND = 5;
    private static final int VALID_NAME_SIZE_LOWER_BOUND = 2;
    private static final int VALID_NAME_SIZE_UPPER_BOUND = 4;
    private static final int VALID_MENU_SIZE_UPPER_BOUND = 2;
    private static final String INVALID_COACHES_SIZE_MESSAGE = "코치님의 인원은 2~5명이어야 합니다.";
    private static final String INVALID_NAME_SIZE_MESSAGE = "코치님의 이름은 2~4 글자여야 합니다.";
    private static final String INVALID_MENU_SIZE_MESSAGE = "싫어하는 음식은 0~2개여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int SPLIT_INDEX = -1;

    public static void validateCoachName(String inputNames) {
        List<String> names = splitNames(inputNames);
        validateNames(names);
        validateSize(names);
    }

    private static List<String> splitNames(String inputNames) {
        return Arrays.stream(inputNames.split(DELIMITER, SPLIT_INDEX))
                .collect(Collectors.toList());
    }

    private static void validateNames(List<String> names) {
        boolean result = names.stream().anyMatch(InputValidator::validateName);
        if (result) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }

    private static boolean validateName(String name) {
        return name.length() < VALID_NAME_SIZE_LOWER_BOUND || name.length() > VALID_NAME_SIZE_UPPER_BOUND;
    }

    private static void validateSize(List<String> names) {
        if (names.size() < COACHES_SIZE_LOWER_BOUND || COACHES_SIZE_UPPER_BOUND < names.size()) {
            throw new IllegalArgumentException(INVALID_COACHES_SIZE_MESSAGE);
        }
    }

    public static void validateMenuNames(String inputNames) {
        List<String> names = splitNames(inputNames);
        validateMenuSize(names);
    }

    private static void validateMenuSize(List<String> names) {
        if (VALID_MENU_SIZE_UPPER_BOUND < names.size()) {
            throw new IllegalArgumentException(INVALID_MENU_SIZE_MESSAGE);
        }
    }
}
