package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constants.CoachRules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> readCoachName() {
        try{
            List<String> coaches = Arrays.stream(Console.readLine().split(","))
                    .collect(Collectors.toList());
            validate(coaches);
            return coaches;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }

    private static void validate(List<String> coaches) {
        if (coaches.size() < CoachRules.MIN_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MIN.getMessage());
        }
        if (coaches.size() > CoachRules.MAX_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MAX.getMessage());
        }
    }

    public static List<String> readInedibleFoods() {
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }
}
