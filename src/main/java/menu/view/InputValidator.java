package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final InputValidator inputValidator = new InputValidator();


    private static final String SEPARATOR = ",";

    private static final String INVALID_COACH_FORMAT = "코치 이름은 2-4 글자여야 합니다.";
    private static final String INVALID_COACH_COUNT = "2명에서 5명 사이의 코치를 입력해야 합니다.";
    private static final String COACH_NAME_FORMAT = "[가-힣]{2,4}";
    private static final int MAX_COACH_SIZE = 5;
    private static final int MIN_COACH_SIZE = 2;

    private static final String MENU_FORMAT = "[가-힣]{1,}";
    private static final String INVALID_MENU_FORMAT = "1글자 이상의 이름을 입력해야 합니다.";

    private static final int MAX_MENU_SIZE = 2;
    private static final String INVALID_MENU_COUNT = "못먹는 메뉴는 최대 2개까지 입력 가능합니다.";

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        return inputValidator;
    }

    public void validateCoach(String input) {
        List<String> names = Arrays.stream(input.split(SEPARATOR))
                .collect(Collectors.toUnmodifiableList());

        if(!isValidCoachFormat(names)) {
            throw new IllegalArgumentException(INVALID_COACH_FORMAT);
        }
        if(!isValidCoachCount(names)) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT);
        }
    }

    private boolean isValidCoachFormat(List<String> names) {
        return names.stream()
                .allMatch(name -> name.matches(COACH_NAME_FORMAT));
    }

    private boolean isValidCoachCount(List<String> names) {
        return MIN_COACH_SIZE <= names.size() && names.size() <= MAX_COACH_SIZE;
    }



    public void validateHateMenu(String input) {
        List<String> menus = Arrays.stream(input.split(SEPARATOR))
                .collect(Collectors.toUnmodifiableList());
        if(!isValidMenuFormat(menus)) {
            throw new IllegalArgumentException(INVALID_MENU_FORMAT);
        }
        if(!isValidMenuCount(menus)) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT);
        }
    }

    private boolean isValidMenuFormat(List<String> menus) {
        return menus.stream()
                .allMatch(menu -> menu.matches(MENU_FORMAT));

    }

    private boolean isValidMenuCount(List<String> menus) {
        return menus.size() <= MAX_MENU_SIZE;
    }
}

