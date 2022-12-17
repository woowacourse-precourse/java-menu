package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final InputValidator inputValidator;

    private static final String SPLIT_DELIMITER = ",";
    private static final String BLANK = "";

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

    public List<String> readCannotEatFoods() {
        String cannotEatFoods = Console.readLine();
        List<String> cannotEatFoodsToReturn = Collections.emptyList();
        if (!cannotEatFoods.equals(BLANK)) {
            List<String> collectedcannotEatFoods = Arrays.stream(cannotEatFoods.split(SPLIT_DELIMITER))
                    .collect(Collectors.toList());
            inputValidator.validateReadCannotEatFoods(collectedcannotEatFoods);
            return collectedcannotEatFoods;
        }
        return cannotEatFoodsToReturn;
    }
}
