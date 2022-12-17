package menu.view;

import java.util.Arrays;

public class InputValidator {

    public static void validateCoachNames(String format) {
        String[] names = format.split(",");
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
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException("코치 명수 에러");
        }
    }

    private static void validateCoachName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치 이름 에러");
        }
    }

    public static void validateNoEat(String format) {
        String[] noEat = format.split(",");
        validateNoEatLength(noEat);
        validateDuplication(noEat);
    }

    private static void validateNoEatLength(String[] noEat) {
        if (noEat.length > 2) {
            throw new IllegalArgumentException("못 먹는 음식 에러");
        }
    }
}
