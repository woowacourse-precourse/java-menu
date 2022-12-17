package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_COACH_NAMES_PREFIX = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_INEDIBLES_PREFIX = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String inputCoachNames(){
        System.out.println(INPUT_COACH_NAMES_PREFIX);
        return Console.readLine();
    }

    public static String inputCoachInedibles(String name){
        System.out.println(String.format(INPUT_COACH_INEDIBLES_PREFIX,name));
        return Console.readLine();
    }
}
