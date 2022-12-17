package menu.util;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static String NAME_REGEX = "^[a-zA-Zㄱ-ㅎ가-힣]+$";

    public static void checkNames(List<String> names) {
        names.stream()
            .filter(name -> !Pattern.matches(NAME_REGEX, name))
                .forEach(name -> {
            throw new IllegalArgumentException("이름 입력 값을 확인하세요");
        });
    }
}
