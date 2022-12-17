package menu.view;

import menu.domain.Validator;

import java.lang.reflect.Array;
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

    public static List<String> inputInEdibleMenu(String coach) {
        OutputView.printInputInEdible(coach);
        try {
            List<String> inEdibleMenu = Arrays.asList(Console.readLine().split(","));
            Validator.validateInEdibleMenuLength(inEdibleMenu);
            return inEdibleMenu;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputInEdibleMenu(coach);
        }
    }
}
