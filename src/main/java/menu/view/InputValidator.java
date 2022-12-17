package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;

import java.util.Arrays;

import static menu.view.InputView.INPUT_DELIMITER;

public class InputValidator {

    public static void validateCoachNames(String format) {
        String[] names = format.split(INPUT_DELIMITER);
        Arrays.stream(names)
                .forEach(InputValidator::validateCoachName);
        validateNamesSize(names);
        validateDuplication(names);
    }

    private static void validateDuplication(String[] names) {
        if (countDistinctNames(names) != names.length) {
            throw new IllegalArgumentException("이름 중복 오류");
        }
    }

    private static long countDistinctNames(String[] names) {
        return Arrays.stream(names).distinct().count();
    }

    private static void validateNamesSize(String[] names) {
        if (names.length < Coaches.NUMBER_LOWER_BOUNDS || names.length > Coaches.NUMBER_UPPER_BOUNDS) {
            throw new IllegalArgumentException("코치 명수 에러");
        }
    }

    private static void validateCoachName(String name) {
        if (name.length() < Coach.NAME_LENGTH_LOWER_BOUNDS || name.length() > Coach.NAME_LENGTH_UPPER_BOUNDS) {
            throw new IllegalArgumentException("코치 이름 에러");
        }
    }

    public static void validateNoEat(String format) {
        String[] noEat = format.split(",");
        validateNoEatLength(noEat);
        validateDuplication(noEat);
    }

    private static void validateNoEatLength(String[] noEat) {
        if (noEat.length > Coach.NO_EAT_NUMBER_UPPER_BOUNDS) {
            throw new IllegalArgumentException("못 먹는 음식 에러");
        }
    }
}
