package menu.input;

import java.util.Scanner;
import menu.message.ErrorMessage;
import menu.output.ErrorMessageOutput;
import menu.output.InputGuideView;
import menu.validator.InputValidator;

public class InputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String[] readCoachNames() {
        String inputNames;
        while (true) {
            InputGuideView.printStartMessage();
            inputNames = scanner.nextLine();
            if (InputValidator.isValidNameInput(inputNames)) {
                break;
            }
            ErrorMessageOutput.printErrorMessage(ErrorMessage.coachNameInputError);
        }
        return inputNames.split(" ");
    }
}
