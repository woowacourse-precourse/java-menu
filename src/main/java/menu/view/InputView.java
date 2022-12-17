package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidation;

import java.util.List;

public class InputView {
    private final InputValidation inputValidation = new InputValidation();

    public List<String> getCoachNames() {
        String userInput = Console.readLine();
        return inputValidation.validateCoach(userInput);
    }

    public List<String> getNotEatFoods() {
        String userInput = Console.readLine();
        return inputValidation.validateNotEatFood(userInput);
    }
}
