package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_MAIN = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_NOT_FOOD = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String mainInput() {
        System.out.println(INPUT_MAIN);
        String input = Console.readLine();
        printBreak();
        return input;
    }
    public static String notFoodInput() {
        System.out.println(INPUT_NOT_FOOD);
        String input = Console.readLine();
        printBreak();
        return input;
    }
}
