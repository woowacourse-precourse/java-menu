package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCoachNames() {
        String input = readValidInputBy(Validator.COACH_NAME);
        List<String> names = Arrays.asList(input.split(Validator.COACH_NAME.getValidDelimiter()));
        validateCoachSize(names);
        validateCoachName(names);
        validateDuplication(names);
        return names;
    }

    private void validateCoachSize(List<String> names) {
        int coachCount = names.size();
        if (coachCount < 2 || coachCount > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명 입력이 가능합니다.");
        }
    }

    private void validateCoachName(List<String> names) {
        for (String name : names) {
            String nameValidFormat = "[가-힣]{2,4}";
            if (!name.matches(nameValidFormat)) {
                throw new IllegalArgumentException("[ERROR] 코치 이름 형식이 올바르지 않습니다.");
            }
        }
    }

    public List<String> readHateMenus() {
        String input = Console.readLine();
        List<String> menus = new ArrayList<>();
        if (input.contains(Validator.MENU_NAME.getValidDelimiter())) {
            menus = Arrays.asList(input.split(Validator.MENU_NAME.getValidDelimiter()));
            validateMenuSize(menus);
            validateDuplication(menus);
            return menus;
        }
        menus.add(input);
        return menus;
    }

    private void validateMenuSize(List<String> names) {
        int size = names.size();
        if (size > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개 입력이 가능합니다.");
        }
    }

    private void validateDuplication(List<String> names) {
        if (hasDuplication(names)) {
            throw new IllegalArgumentException("[ERROR] 입력이 중복되었습니다.");
        }
    }

    private boolean hasDuplication(List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }

    private String readValidInputBy(Validator validator) {
        String input = Console.readLine();
        validator.validate(input);
        return input;
    }
}
