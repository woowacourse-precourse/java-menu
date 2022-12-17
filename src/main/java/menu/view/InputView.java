package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.util.InputValidator.validateNameLength;
import static menu.util.InputValidator.validateNamesSize;

public class InputView {
    public static String readCoachName() {
        OutputView.printStartMessage();

        String coachName = Console.readLine();
        validateNameLength(coachName);
        validateNamesSize(coachName);
        return coachName;
    }
}
