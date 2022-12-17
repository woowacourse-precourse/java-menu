package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constants.CoachRules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final int INEDIBLE_MAX = 2;

    public static List<String> readCoachName() {
        try {
            List<String> coaches = Arrays.stream(Console.readLine().split(","))
                    .collect(Collectors.toList());
            validateNumberOfCoaches(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }

    private static void validateNumberOfCoaches(List<String> coaches) {
        if (coaches.size() < CoachRules.MIN_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MIN.getMessage());
        }
        if (coaches.size() > CoachRules.MAX_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MAX.getMessage());
        }
    }

    public static List<String> readInedibleFoods() {
        try {
            List<String> InedibleFoods = Arrays.stream(Console.readLine().split(","))
                    .collect(Collectors.toList());
            validateInedible(InedibleFoods);
            return InedibleFoods;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInedibleFoods();
        }
    }

    private static void validateInedible(List<String> foods) {
        if (foods.size() > INEDIBLE_MAX) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_OF_INEDIBLE.getMessage());
        }
    }
}
