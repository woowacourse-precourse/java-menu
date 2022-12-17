package menu.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.validator.Validator;

public class Input {
    private final Validator validator;
    private final Output output;

    public Input() {
        this.validator = new Validator();
        this.output = new Output();
    }

    private String input() {
        return Console.readLine();
    }

    public String coachNamesInput() {
        String result = "";
        while (true) {
            try {
                System.out.println();
                output.printRequestCoachNames();
                result = input();
                validator.validCoachNameInput(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public List<String> cantEatFoodInputEachCoach(String coachNames) {
        List<String> result = new ArrayList<>();
        String[] split = coachNames.split(",");
        for (String s : split) {
            result.add(cantEatFoodInput(s));
        }
        return result;
    }

    private String cantEatFoodInput(String coachName) {
        String result = "";
        while (true) {
            try {
                output.printRequestCoachCantEatFood(coachName);
                result = Console.readLine();
                validator.validCantEatFoodSize(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result.trim();
    }
}
