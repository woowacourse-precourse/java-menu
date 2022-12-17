package menu.view;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public void validateCoachNamesCommand(String command) {
        List<String> names = Arrays.asList(command.split(","));
        // 코치 수는 2~5명
        if (names.size() < 2 || 6 < names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.");
        }
        // 코치 이름은 최소 2글자 ~ 최대 4글자
        for (String name : names) {
            if (name.length() < 2 || 5 < name.length()) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자입니다.");
            }
        }

    }

    public void validateNoEatFoodsCommand(String command) {
        List<String> foods = Arrays.asList(command.split(","));
        // 각 코치는 0~2개의 못 먹는 메뉴가 있다.
        if (foods.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 각 코치는 0~2개의 못 먹는 메뉴가 있다.");
        }
    }
}
