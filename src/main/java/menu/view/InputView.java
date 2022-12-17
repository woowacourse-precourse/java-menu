package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.constant.SystemConstant.COACH_INPUT_SPLIT_OPTION;

public class InputView {

    public static List<String> inputCoachesName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input =  Console.readLine();
        System.out.println();
        return parseToCoachesName(input);
    }

    private static List<String> parseToCoachesName(String input) {
        return Arrays.stream(input.split(COACH_INPUT_SPLIT_OPTION))
                .collect(Collectors.toUnmodifiableList());
    }
}
