package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidation;

public class InputView {
    private final InputValidation inputValidation = new InputValidation();

    public String[] getCoachNames() {
        String userInput = Console.readLine();
        return inputValidation.validateCoach(userInput);
    }
}
