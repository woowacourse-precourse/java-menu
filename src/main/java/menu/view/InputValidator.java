package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static menu.message.ErrorMsg.*;

public class InputValidator {

    private static final String COMMA = ",";
    private static final int LOWER_COACH_NUMBER_INCLUSIVE = 2;
    private static final int UPPER_COACH_NUMBER_INCLUSIVE = 5;


    public List<String> toStrList(String input) {
        return Stream.of(input.split(COMMA))
                .collect(Collectors.toList());
    }

    public void validateCoachesName(List<String> coachesName) {
        if (coachesName.size() < LOWER_COACH_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_SIZE_OF_COACHES_NAME_IS_UNDER_TWO.get());
        }
        if (coachesName.size() > UPPER_COACH_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_SIZE_OF_COACHES_NAME_IS_OVER_FIVE.get());
        }
    }
}
