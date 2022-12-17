package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputValidation;

import java.util.List;

public class InputView {
    private static final String INPUT_COACHES_NAME = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_HATE_MENU_FORMAT = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";
    private static final String SPACE = " ";
    private static final String NONE = "";

    public List<String> readCoachesName() {
        System.out.println(INPUT_COACHES_NAME);
        return InputValidation.validateCoachesName(Console.readLine().replace(SPACE, NONE));
    }

    public List<String> readCoachHateMenu(String name) {
        System.out.printf(INPUT_HATE_MENU_FORMAT, name);
        return InputValidation.validateHateMenus(Console.readLine().replace(SPACE, NONE));
    }
}
