package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final InputValidator inputValidator;

    private static final String SPLIT_DELIMITER = ",";

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public List<String> readCoachNames() {
        String coachNames = Console.readLine();
        List<String> collectedCoachNames = Arrays.stream(coachNames.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
        inputValidator.validateReadCoachNames(collectedCoachNames);
        return collectedCoachNames;
    }
}
