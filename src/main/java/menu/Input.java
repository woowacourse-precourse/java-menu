package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Input {

    private final static String DELiMITER = ",";
    private final static int COACH_MAX_AMOUNT = 5;
    private final static int COACH_MIN_AMOUNT = 2;
    private final static int HATE_MAX_AMOUNT = 2;
    private final static int NAME_MAX_LENGTH = 4;
    private final static int NAME_MIN_LENGTH = 2;

    public static String[] inputName() {
        System.out.println(Output.INPUT_COACH);
        String input = Console.readLine();
        validateCoach(input);
        return input.split(DELiMITER);
    }

    public static void validateCoach(String input) {
        String[] split = input.split(DELiMITER);
        validateDuplicate(split);
        if (split.length > COACH_MAX_AMOUNT || split.length < COACH_MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.COACH_AMOUNT_RANGE.toString());
        }
        for (String coachName : split) {
            if (coachName.length() > NAME_MAX_LENGTH || coachName.length() < NAME_MIN_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_RANGE.toString());
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
        if (input.trim().equals("")) {
            return;
        }
        String[] split = input.split(DELiMITER);
        validateDuplicate(split);
        if (split.length > HATE_MAX_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.HATE_AMOUNT.toString());
        }
        for (String food : split) {
            boolean contain = Arrays.stream(Dish.values()).anyMatch(s -> s.menus.contains(food));
            if (!contain) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_IN_LIST.toString());
            }
        }
    }

    private static void validateDuplicate(String[] split) {
        Set<String> set = new HashSet<>(List.of(split));
        if (set.size() != split.length) {
            throw new IllegalArgumentException(ErrorMessage.NON_DUPLICATE.toString());
        }
    }
}
