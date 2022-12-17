package menu.view;

import static menu.view.OutputView.printError;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.InputException;

public class InputView {

    private final InputException inputException = new InputException();

    public String readCoachName() {
        try {
            String input = Console.readLine();
            inputException.validateCoaches(input);
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readCoachName();
        }
    }

    public String readBannedFoods() {
        try {
            String input = Console.readLine();
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readBannedFoods();
        }
    }

}
