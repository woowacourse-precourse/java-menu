package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String COACH_NAME_LENGTH_ERROR_MESSAGE = "코치의 이름 길이는 최소 2, 최대 4여야 합니다.";
    private static final String COACH_NUMBER_ERROR_MESSAGE = "코치는 최소 2명, 최대 5명 입력해야 합니다.";
    private static final String MENU_NUMBER_ERROR_MESSAGE = "못 먹는 메뉴 개수는 최소 0, 최대 2여야 합니다.";
    private static final String MENU_NAME_ERROR_MESSAGE = "존재하지 않는 메뉴입니다.";

    public List<String> readCoachNames() {
        List<String> coachNameInput = Arrays.asList(Console.readLine().split(","));

    }

    private void validateCoachNameLength(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    
}
