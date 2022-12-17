package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private final static String DELiMITER = ",";

    public static String[] inputName() {
        String input = Console.readLine();
        validateCoach(input);
        return input.split(DELiMITER);
    }

    public static void validateCoach(String input) {
        String[] split = input.split(DELiMITER);
        if (split.length > 5 || split.length < 2) {
            throw new IllegalArgumentException();
        }
        for (String coachName : split) {
            if (coachName.length() > 4 || coachName.length() < 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<String> inputHate() {
        String input = Console.readLine();
        validateHate(input);
        List<String> hateFoods = new ArrayList<>(List.of(input.split(DELiMITER)));
        return hateFoods;
    }

    public static void validateHate(String input) {
        String[] split = input.split(DELiMITER);
        if (split.length > 2) {
            throw new IllegalArgumentException();
        }
        for (String food : split) {
            boolean contain = Arrays.stream(Dish.values()).anyMatch(s -> s.menus.contains(food));
            if (!contain) {
                throw new IllegalArgumentException();
            }
        }
    }
}
