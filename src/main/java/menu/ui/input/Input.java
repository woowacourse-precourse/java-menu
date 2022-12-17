package menu.ui.input;

import menu.ui.input.exceptions.CoachList;
import menu.ui.input.exceptions.Menus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String COACH_NAME_INPUT_NOTIFICATION = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENU_INPUT_NOTIFICATION = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COMMA = ",";

    public List<String> receiveCoaches() {
        Repetitor input = new CoachList();
        String coachNames = input.getResult(COACH_NAME_INPUT_NOTIFICATION);

        return Arrays.asList(coachNames.split(COMMA));
    }

    public List<List<String>> receiveUnavailableMenu(List<String> coaches) {
        List<List<String>> result = new ArrayList<>();
        Repetitor input = new Menus();

        for (String coach : coaches) {
            String unavailableMenus = input.getResult(coach + MENU_INPUT_NOTIFICATION);
            result.add(Arrays.asList(unavailableMenus.split(COMMA)));
        }

        return result;
    }
}
