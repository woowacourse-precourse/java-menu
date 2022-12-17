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

    public static String getCantEatMenu(String coachName) {
        try {
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
            return InputValidator.validateCantEatMenu(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getCantEatMenu(coachName);
        }
    }
}
