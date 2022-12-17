package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.utils.validator.CoachNameInputValidator;
import menu.utils.validator.InputValidator;
import menu.utils.validator.UnEatableInputValidator;

public class InputView {

    InputValidator validator;

    public List<String> readCoachNames() {
        validator = new CoachNameInputValidator();
        try {
            String input = Console.readLine();
            validator.validate(input);
            return Arrays.stream(input.split(",")).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachNames();
        }
    }

    public List<String> readUnEatableFoods() {
        validator = new UnEatableInputValidator();
        try {
            String input = Console.readLine();
            validator.validate(input);
            return Arrays.stream(input.split(",")).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUnEatableFoods();
        }
    }
}
