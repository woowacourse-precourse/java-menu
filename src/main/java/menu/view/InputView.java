package menu.view;


import camp.nextstep.edu.missionutils.Console;
import menu.Constant;
import menu.ExceptionMessage;
import menu.vo.Coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCoachName() throws IllegalArgumentException{
        System.out.println("점심 메뉴 추천을 시작합니다. \n\n코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> nameInput = splitInput(Console.readLine());
        coachSizeValidation(nameInput);
        coachNameLengthValidation(nameInput);
        return trimEachInput(splitInput(Console.readLine()));
    }

    public List<Coach> getCoachNotEat(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            System.out.printf(Constant.inputNotEatFood,name);
            List<String> notEatFoods = trimEachInput(splitInput(Console.readLine()));
            coaches.add(new Coach(name,notEatFoods));
        }
        return coaches;
    }

    // 입력값을 "," 단위로 분해
    private List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    // 입력값 각각을 trim
    private List<String> trimEachInput(List<String> inputs) {
        List<String> returnWords = new ArrayList<>();
        for(String word : inputs) {
            returnWords.add(word.trim());
        }
        return returnWords;
    }

    // 코치의 이름은 최소 2글자, 최대 4글자 (Validation.1)
    private void coachNameLengthValidation(List<String> coachNames) {
        for (String name : coachNames) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(
                        ExceptionMessage.INVALID_COACH_NAME_LEN.getMessage());
            }
        }
    }

    // 코치는 최소 2명, 최대 5명까지 식사를 함께 해야 함 (Validation.2)
    private void coachSizeValidation(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_COACH_SIZE.getMessage());
        }
    }

    // 못먹는 메뉴는 2개를 넘을 수 없음 (Validation.3)
    private void notEatFoodSizeValidation(List<String> notEatFoods) {
        if (notEatFoods.size() > 2) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_NOT_EAT_SIZE.getMessage());
        }
    }

}
