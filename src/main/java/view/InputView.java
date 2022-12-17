package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Validator;

public class InputView {
    private static final String INPUT_COACH_NAME_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_HATE_FOOD_COMMENT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String getCoachNames() {
        String coachNames;

        do {
            System.out.println(INPUT_COACH_NAME_COMMENT);
            coachNames = Console.readLine();
        } while (!Validator.isValidCoachNames(coachNames));

        return coachNames;
    }

    public String getHateFood(String name) {
        String hateFoods;

        do {
            System.out.println();
            System.out.printf(INPUT_COACH_HATE_FOOD_COMMENT, name);
            hateFoods = Console.readLine();
        } while (!Validator.isValidFoodName(hateFoods));

        return hateFoods;
    }
}
