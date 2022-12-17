package menu.util;

import menu.domain.DomainCondition;

import java.util.ArrayList;
import java.util.List;

import static menu.constant.ExceptionMessage.WRONG_COACH_COUNT;
import static menu.constant.ExceptionMessage.WRONG_COACH_NAME_LENGTH;
import static menu.domain.DomainCondition.*;

public class InputValidation {

    public List<String> validateCoach(String userInput) {
        List<String> coachNames = validateCoachCount(userInput);
        for (String coachName : coachNames) {
            validateCoachName(coachName);
        }
        return coachNames;
    }

    public List<String> validateNotEatFood(String userInput) {
        String[] notEatFoods = userInput.split(",");
        List<String> foodNames = removeBlankInput(notEatFoods);
        if (!DomainCondition.validFoodCount(foodNames)) {
            throw new IllegalArgumentException();
        }
        return foodNames;
    }

    private void validateCoachName(String coachName) {
        if(!DomainCondition.validCoachNameLength(coachName)) {
            throw new IllegalArgumentException(String.format(WRONG_COACH_NAME_LENGTH.getValue(), MIN_COACH_NAME_LENGTH.getValue(), NAX_COACH_NAME_LENGTH.getValue()));
        }
    }

    private List<String> validateCoachCount(String userInput) {
        String[] userInputs = userInput.split(",");
        List<String> coachNames = removeBlankInput(userInputs);
        if(!DomainCondition.validCoachCount(coachNames)) {
            throw new IllegalArgumentException(String.format(WRONG_COACH_COUNT.getValue(), MIN_COACH_COUNT.getValue(), MAX_COACH_COUNT.getValue()));
        }
        return coachNames;
    }

    /**
     * 사용자가 공백을 입력했을 경우 해당 값을 제거하고 리스트로 만들어주는 메서드.
     * @param userInput 사용자의 입력값
     * @return 생성된 리스트
     */
    private List<String> removeBlankInput(String[] userInput) {
        List<String> inputs = new ArrayList<>();
        for (String input : userInput) {
            if(input.trim().length() > 0) {
                inputs.add(input.trim());
            }
        }
        return inputs;
    }
}
