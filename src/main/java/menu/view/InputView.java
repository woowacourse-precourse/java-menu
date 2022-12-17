package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NO_EATABLE_SUFFIX = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String INPUT_COACH_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static String inputCoachNames() {
        System.out.println(INPUT_COACH_MESSAGE);
        String names = Console.readLine();
        return names;
    }

    public static String inputNoEatableMenus(String name) {
        System.out.println(name + NO_EATABLE_SUFFIX);
        return Console.readLine();
    }
}
