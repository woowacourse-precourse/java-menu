package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static List<String> inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = Console.readLine();
        String[] splitNames = names.split(",");
        return Arrays.asList(splitNames);
    }
}
