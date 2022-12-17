package menu.ui.view;

import camp.nextstep.edu.missionutils.Console;
import menu.ui.dto.CoachesRequest;
import menu.ui.dto.MenuRequest;

public class InputView {

    private InputView() {

    }

    public static InputView getInstance() {
        return new InputView();
    }

    public CoachesRequest requestCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String userInput = Console.readLine();
        return CoachesRequest.from(userInput);
    }

    public MenuRequest getCoachAvoidMenu(String coachName) {
        String format = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

        System.out.println(String.format(format, coachName));
        String userInput = Console.readLine();
        return MenuRequest.from(userInput);
    }
}
