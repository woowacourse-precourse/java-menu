package menu.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_coach_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String INPUT_CANNOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    InputViewValidation validation = new InputViewValidation();

    public String inputcoachNames() {
        System.out.println(INPUT_coach_NAMES);
        String input = Console.readLine();
        validation.coachNameValidate(input);
        validation.coachNumValidate(input);
        return input;
    }

    public String inputCannotEat(String coachName) {
        System.out.println(coachName + INPUT_CANNOT_EAT);
        String input = Console.readLine();
        validation.coachCannotEatNumValidate(input);
        validation.coachCannotEatFoodValidate(input);
        return input;
    }
}
