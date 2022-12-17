package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_COACH_NAME_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_CAN_NOT_EAT_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String readName() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);

        return Console.readLine();
    }

    public String readCanNotEat(String name) {
        System.out.printf(INPUT_COACH_CAN_NOT_EAT_MESSAGE, name);

        return Console.readLine();
    }
}
