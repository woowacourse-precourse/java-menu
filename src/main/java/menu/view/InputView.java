package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_CAN_NOT_EAT_MENU_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    InputValidator inputValidator = new InputValidator();

    public List<String> readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String line = Console.readLine();
        List<String> coachNames = new ArrayList<>(Arrays.asList(line.split(",")));
        inputValidator.validateCoachNamesLength(coachNames);

        for (String coachName : coachNames) {
            inputValidator.validateCoachName(coachName);
        }

        return coachNames;
    }

    public List<String> readCanNotEatMenus(String coachName) {
        System.out.printf((READ_CAN_NOT_EAT_MENU_MESSAGE) + "%n", coachName);
        String line = Console.readLine();
        if (line.equals("")) {
            return new ArrayList<>();
        }
        List<String> canNotEatMenus = new ArrayList<>(Arrays.asList(line.split(",")));
        inputValidator.validateCanNotEatMenusLength(canNotEatMenus);

        for (String canNotEatMenu : canNotEatMenus) {
            inputValidator.validateCanNotEatMenu(canNotEatMenu);
        }

        return canNotEatMenus;
    }
}
