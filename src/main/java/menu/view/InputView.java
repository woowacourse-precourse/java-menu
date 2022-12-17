package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.validation.Validation;

public class InputView {

    private static final String COACH_NAME_INPUT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String SPLIT = ",";

    // 코치를 입력 받는 기능
    public static List<String> inputCoachName () {
        OutputView.printPhrase(COACH_NAME_INPUT);
        List<String> names = Arrays.asList(Console.readLine().split(SPLIT));
        Validation.validateCoachsLength(names);
        Validation.validateCoachNameLength(names);
        return names;
    }

}
