package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.dto.CoachRequestDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_CANNOT_EAT_FOOD_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";
    private static final String REGEX_SPLIT = ",";

    private InputView() {
    }

    public static List<String> inputCoachNames() {
        System.out.println(INPUT_COACH_NAMES_MESSAGE);
        String names = Console.readLine();
        String[] splitNames = names.split(REGEX_SPLIT);
        return Arrays.asList(splitNames);
    }

    public static List<CoachRequestDto> inputCanNotEatFoods(List<String> coachNames) {
        List<CoachRequestDto> coachRequestDtos = new ArrayList<>();
        for (String coachName : coachNames) {
            System.out.printf(INPUT_CANNOT_EAT_FOOD_MESSAGE, coachName);
            List<String> canNotEatFood = inputCanNotEatFood();
            CoachRequestDto requestDto = new CoachRequestDto(coachName, canNotEatFood);
            coachRequestDtos.add(requestDto);
        }
        return coachRequestDtos;
    }

    private static List<String> inputCanNotEatFood() {
        String foods = Console.readLine();
        String[] splitFoods = foods.split(REGEX_SPLIT);
        return Arrays.asList(splitFoods);
    }
}
