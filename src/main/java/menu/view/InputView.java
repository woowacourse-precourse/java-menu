package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public List<String> readCoachNames() {
        String line = Console.readLine();
        List<String> coachNames = new ArrayList<>(Arrays.asList(line.split(",")));

        for (String coachName : coachNames) {
            inputValidator.validateCoachName(coachName);
        }

        return coachNames;
    }
}
