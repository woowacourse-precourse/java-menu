package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputValidation;

import java.util.List;

public class InputView {
    private static final String INPUT_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> readCoachesName() {
        System.out.println(INPUT_COACHES_NAME);
        return InputValidation.validateCoachesName(Console.readLine());
    }
}
