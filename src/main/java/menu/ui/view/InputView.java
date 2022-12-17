package menu.ui.view;

import camp.nextstep.edu.missionutils.Console;
import menu.ui.dto.CoachesRequest;

public class InputView {

    private InputView() {

    }
    public static InputView getInstance() {
        return new InputView();
    }

    public CoachesRequest requestCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String userInput = Console.readLine();
        return null;
    }
}
