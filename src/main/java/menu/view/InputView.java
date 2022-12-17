package menu.view;

import static menu.view.OutputView.printError;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.InputException;

public class InputView {
    private final InputException inputException = new InputException();

    public String readCrewsName() {
        try {
            String input = Console.readLine();
            inputException.validateCrews(input);
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readCrewsName();
        }
    }

    public String readBannedFoods() {
        try {
            String input = Console.readLine();
            inputException.validateBannedFoods(input);
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readBannedFoods();
        }
    }
}
