package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    private static final String SPLIT_DELIMITER = ",";

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readCoachNames() {
        String coachNames = Console.readLine();
        inputValidator.validateReadCoachNames(coachNames.split(SPLIT_DELIMITER));
        return coachNames;
    }
}
