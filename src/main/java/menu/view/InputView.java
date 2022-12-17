package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_COACH_NAMES_PREFIX = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static String inputCoachNames(){
        System.out.println(INPUT_COACH_NAMES_PREFIX);
        return Console.readLine();
    }
}
