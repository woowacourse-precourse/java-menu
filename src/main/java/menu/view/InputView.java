package menu.view;

import menu.domain.Validator;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView(){};

    public static List<String> inputCoaches() {
        OutputView.printInputCoaches();
        try {
            List<String> coaches = Arrays.asList(Console.readLine().split(","));
            Validator.validateCoachesLength(coaches);
            Validator.validateCoachName(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputCoaches();
        }
    }
}
