package menu.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.InputException;

public class InputView extends InputException {
    public List<String> readCoachName() {
        String inputData = Console.readLine();
        List<String> coachName = Arrays.stream(inputData.split(",")).collect(Collectors.toList());
        try {
            validateCoachName(coachName);
            validateCoachCount(coachName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            readCoachName();
        }
        return coachName;
    }

    public Map<String, List<String>> readCoachDislikeFood(List<String> coachName) {
        Map<String, List<String>> coachDislikeFood = new HashMap<>();
        for (int i = 0; i < coachName.size(); i++) {
            System.out.println(coachName.get(i) + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String inputData = Console.readLine();
            List<String> dislikeFood = Arrays.stream(inputData.split(",")).collect(Collectors.toList());
            try {
                validateDislikeFoodCount(dislikeFood);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                i--;
                continue;
            }
            coachDislikeFood.put(coachName.get(i), dislikeFood);
        }
        return coachDislikeFood;
    }
}
