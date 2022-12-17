package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidator;

import java.util.List;

public class InputView {

    private final InputValidator validator;

    public InputView() {
        this.validator = new InputValidator();
    }

    public List<String> readCoach() {
        while (true) {
            try {
                return validator.parseCoach(inputCoaches());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> readRefuseMenu() {
        while (true) {
            try {
                return validator.parseMenu(inputMenu());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private String inputMenu() {
        return Console.readLine();
    }
    private String inputCoaches() {
        return Console.readLine();
    }
}
