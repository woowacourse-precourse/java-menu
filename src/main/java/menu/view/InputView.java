package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.CoachInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public CoachInfo readCoachNames() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return new CoachInfo(Arrays.asList(Console.readLine().split(",")));
    }

    public List<String> readForbiddenMenu() {
        String menus = Console.readLine();
        if (menus.equals("")) {
            return new ArrayList<>();
        }
        return Arrays.asList(menus.split(","));
    }
}
