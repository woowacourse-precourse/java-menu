package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidator;

public class InputView {

    public static String getCoachNames() {
        try {
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            return InputValidator.validateCoachNames(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getCoachNames();
        }
    }
}
