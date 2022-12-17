package menu.view;

import java.util.Arrays;

public class InputValidator {

    public static void validateCoachNames(String format) {
        String[] names = format.split(",");
        Arrays.stream(names)
                .forEach(InputValidator::validateCoachName);
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
        if (noEat.length > 2) {
            throw new IllegalArgumentException("못 먹는 음식 에러");
        }
    }
}
