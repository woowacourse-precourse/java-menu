package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputViewValidation;

import java.util.List;

import static menu.constant.MessageConstant.MESSAGE_INPUT_COACH_NAME;

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
}
