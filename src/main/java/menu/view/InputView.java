package menu.view;

import static menu.view.OutputView.printError;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCrewsName() {
        try {
            String input = Console.readLine();
            // todo : 예외
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readCrewsName();
        }
    }

    public String readBannedFoods() {
        try {
            String input = Console.readLine();
            // todo : 예외
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readBannedFoods();
        }
    }
}
