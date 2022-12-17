package menu.view;

import menu.enums.MenuOption;
import menu.module.NotModule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static menu.message.ErrorMsg.*;

public class InputValidator extends NotModule {

    private static final String COMMA = ",";
    private static final int LOWER_COACH_NUMBER_INCLUSIVE = 2;
    private static final int UPPER_COACH_NUMBER_INCLUSIVE = 5;
    private static final int UPPER_SIZE_OF_HATE_FOODS_INCLUSIVE = 2;


    public List<String> toStrList(String input) {
        return Stream.of(input.split(COMMA))
                .collect(Collectors.toList());
    }

    public void validateCoachesName(List<String> coachesName) {
        if (isDuplicatedList(coachesName)) {
            throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_ELEMENT_IN_LIST.get());
        }
        if (coachesName.size() < LOWER_COACH_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_SIZE_OF_COACHES_NAME_IS_UNDER_TWO.get());
        }
        if (coachesName.size() > UPPER_COACH_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_SIZE_OF_COACHES_NAME_IS_OVER_FIVE.get());
        }
    }

    public void validateHateFoods(List<String> hateFoods) {
        if (isNotExistFoods(hateFoods)) {
            throw new IllegalArgumentException(ERROR_MSG_FOOD_IS_NOT_EXIST_IN_MENU.get());
        }
        if (isDuplicatedList(hateFoods)) {
            throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_ELEMENT_IN_LIST.get());
        }
        if (hateFoods.size() > UPPER_SIZE_OF_HATE_FOODS_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_SIZE_OF_HATE_FOODS_IS_OVER_TWO.get());
        }
    }

    private boolean isDuplicatedList(List<String> data) {
        return not(data.size() == data.stream()
                .distinct()
                .count());
    }

    private boolean isNotExistFoods(List<String> hateFoods) {
        for (String food : hateFoods) {
            if (not(MenuOption.isExistFood(food))) {
                return true;
            }
        }

        return false;
    }
}
