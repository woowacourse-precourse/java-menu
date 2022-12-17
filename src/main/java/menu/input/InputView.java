package menu.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.output.ErrorMessageOutput;
import menu.output.InputGuideView;
import menu.validator.InputValidator;

public class InputView {

    public static List<Coach> readCoachNames() {
        while (true) {
            InputGuideView.printStartMessage();
            String inputNames = Console.readLine();
            try {
                InputValidator.validateNameInput(inputNames);
                return generateCoaches(inputNames.split(","));
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorMessageOutput.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static List<Coach> generateCoaches(String[] inputNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : inputNames) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    public static void readInedibleFoodsOfCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            readInedibleFood(coach);
        }
    }

    private static void readInedibleFood(Coach coach) {
        while (true) {
            InputGuideView.printInputInedibleFoodsMessage(coach.getName());
            String inedibleFoods = Console.readLine();
            try {
                InputValidator.validateInedibleFoodsInput(inedibleFoods);
                coach.SetInedibleFoods(inedibleFoods);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorMessageOutput.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
