package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_COACH_NAME_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_INEDIBLE_FOOD_NAME_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String[] readCoachName() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        String[] names = Console.readLine().split(",");
        Validator.validateCoachName(names);
        return names;
    }

    public String[] readInedibleFoodName(String coachName) {
        System.out.println("\n" + coachName + INPUT_INEDIBLE_FOOD_NAME_MESSAGE);
        String[] names = Console.readLine().split(",");
        Validator.validateFoodName(names);
        return names;
    }
}
