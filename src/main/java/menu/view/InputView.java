package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCoachName() {
        printInputCoachName();

        String names = Console.readLine();
        List<String> coachNames = convertNameStringToList(names);

        while (handlingCoachNameException(coachNames)) {
            printInputCoachName();
            names = Console.readLine();

            coachNames = convertNameStringToList(names);
        }

        return coachNames;
    }

    private List<String> convertNameStringToList(final String names) {
        return Arrays.stream(names.split(","))
                     .collect(Collectors.toList());
    }

    private boolean handlingCoachNameException(final List<String> names) {
        try {
            for (String name : names) {
                InputValidator.isCorrectLength(name);
            }
            InputValidator.isLimit(names.size());
            return false;
        } catch (IllegalArgumentException retry) {
            System.out.println(retry.getMessage());
        }
        return true;
    }

    private void printInputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public Map<String, List<String>> readExceptedFood(final List<String> names) {
        Map<String, List<String>> exceptedFoods = new HashMap<>();

        for (String name : names) {
            printInputExceptedFood(name);
            String exceptedFood = Console.readLine();

            List<String> exceptedFoodsCandidate = convertNameStringToList(exceptedFood);

            for (String candidate : exceptedFoodsCandidate) {
                exceptedFoods.computeIfAbsent(name, k -> new ArrayList<>());
                exceptedFoods.get(name).add(candidate);
            }
        }

        return exceptedFoods;
    }

    private void printInputExceptedFood(final String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
