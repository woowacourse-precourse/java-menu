package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.service.CoachService;

public class InputView {

    public static String inputCoachesName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public static String inputCantEatFood(String coachName ) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
