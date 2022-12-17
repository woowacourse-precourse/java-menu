package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static menu.constant.SystemConstant.INPUT_SPLIT_OPTION;

public class InputView {

    public static List<String> inputCoachesName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input =  Console.readLine();
        System.out.println();
        return parseToSplitOption(input);
    }

    public static List<String> inputDislikeMenus(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input =  Console.readLine();
        System.out.println();
        if (input.length() == 0) {
            return Collections.emptyList();
        }
        return parseToSplitOption(input);
    }

    private static List<String> parseToSplitOption(String input) {
        return Arrays.stream(input.split(INPUT_SPLIT_OPTION))
                .collect(Collectors.toUnmodifiableList());
    }
}
