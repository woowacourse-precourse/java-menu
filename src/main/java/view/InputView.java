package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Validator;

public class InputView {
    private static final String INPUT_COACH_NAME_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String getCoachNames() {
        String coachNames;

        do {
            System.out.print(INPUT_COACH_NAME_COMMENT);
            coachNames = Console.readLine();
        } while (Validator.isValidCoachNames(coachNames));

        return coachNames;
    }
}
