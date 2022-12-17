package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputViewValidation;

import java.util.List;

import static menu.constant.MessageConstant.MESSAGE_INPUT_COACH_NAME;
import static menu.constant.MessageConstant.MESSAGE_INPUT_DISLIKE_FOOD;

public class InputView {

    /**
     * 코치의 이름을 입력받는다.
     */
    public List<String> readCoachName() {
        System.out.println(MESSAGE_INPUT_COACH_NAME);

        String coachInput = Console.readLine();
        InputViewValidation.checkCoachInputValid(coachInput);
        return InputViewValidation.checkCoachInputValid(coachInput);
    }

    /**
     * 못먹는 메뉴를 입력받는다.
     */
    public List<String> readDislikeFood(String coachName) {
        System.out.printf(MESSAGE_INPUT_DISLIKE_FOOD,coachName);
        System.out.println();
        String dislikeFood = Console.readLine();
        return InputViewValidation.checkDislikeFoodValid(dislikeFood);
    }
}
