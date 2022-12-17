package menu.input;

import camp.nextstep.edu.missionutils.Console;
import menu.type.ValidationType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCoaches() {
        String input = Console.readLine();
        String[] coaches = input.split(",");
        validate(ValidationType.CHECK_COACH_SIZE, String.valueOf(coaches.length));
        for (String coach: coaches) {
            validate(ValidationType.CHECK_NAME_SIZE, String.valueOf(coach.length()));
        }
        return Arrays.stream(coaches).collect(Collectors.toList());
    }

    public void validate(ValidationType validationType, String input) {
        if (!ValidationType.validate(validationType, input)) {
            String errorMessage = validationType.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
