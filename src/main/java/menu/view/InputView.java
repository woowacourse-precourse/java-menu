package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;
    private static final int MIN_COACH_NAME_SIZE = 2;
    private static final int MAX_COACH_NAME_SIZE = 4;

    public List<String> readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return validateNames(input);
    }

    private List<String> validateNames(String input) {
        String[] names = input.split(",");
        validateCoachSize(names);

        for (String name : names) {
            name = name.trim();
            validateNameSize(name);
        }

        return Arrays.asList(names);
    }

    private void validateCoachSize(String[] names) {
        if (!(MIN_COACH_SIZE <= names.length && names.length <= MAX_COACH_SIZE)) {
            throw new IllegalArgumentException("코치는 최소 2명에서 5명 사이입니다.");
        }
    }

    private void validateNameSize(String name) {
        int length = name.length();
        if (!(MIN_COACH_NAME_SIZE <= length && length <= MAX_COACH_NAME_SIZE)) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자에서 4글자입니다.");
        }
    }

    public List<String> readCantEatMenu() {
        String input = Console.readLine();
        String[] cantEatMenus = input.split(",");
        validateCantEatMenusSize(cantEatMenus);
        return Arrays.stream(cantEatMenus)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCantEatMenusSize(String[] cantEatMenus) {
        if (2 < cantEatMenus.length) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 입력해 주세요.");
        }
    }
}
