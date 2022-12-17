package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

public class InputView {

    public String readCoachNames() {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validateCoachNamesInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readDislikeFoods() {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validateDislikeFoodsInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
