package menu.input;

import camp.nextstep.edu.missionutils.Console;
import menu.message.ErrorMessage;
import menu.output.ErrorMessageOutput;
import menu.output.InputGuideView;
import menu.validator.InputValidator;

public class InputView {

    public static String[] readCoachNames() {
        String inputNames;
        while (true) {
            InputGuideView.printStartMessage();
            inputNames = Console.readLine();
            if (InputValidator.isValidNameInput(inputNames)) {
                break;
            }
            ErrorMessageOutput.printErrorMessage(ErrorMessage.coachNameInputError);
        }
        return inputNames.split(" ");
    }
}
