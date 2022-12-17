package menu.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.message.ErrorMessage;
import menu.output.ErrorMessageOutput;
import menu.output.InputGuideView;
import menu.validator.InputValidator;

public class InputView {

    public static List<Coach> readCoachNames() {
        String inputNames;
        while (true) {
            InputGuideView.printStartMessage();
            inputNames = Console.readLine();
            if (InputValidator.isValidNameInput(inputNames)) {
                break;
            }
            ErrorMessageOutput.printErrorMessage(ErrorMessage.coachNameInputError);
        }
        return generateCoaches(inputNames.split(","));
    }

    private static List<Coach> generateCoaches(String[] inputNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : inputNames) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }
}
