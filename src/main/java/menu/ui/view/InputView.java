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
        System.out.println(ViewMessage.COACH_NAME_INPUT_MESSAGE);
        String userInput = Console.readLine();
        try {
            return CoachesRequest.from(userInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return this.requestCoachNames();
        }
    }

    public MenuRequest getCoachAvoidMenu(String coachName) {
        String format = ViewMessage.AVOID_MENU_COACH_FORMAT;

        System.out.println(String.format(format, coachName));
        String userInput = Console.readLine();
        return MenuRequest.from(userInput);
    }
}
