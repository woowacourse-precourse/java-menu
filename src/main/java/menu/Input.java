package menu;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final static String DELiMITER = ",";

    public static String inputCoach() {
        String input = Console.readLine();
        validateCoach(input);
        return input;
    }

    private static void validateCoach(String input) {
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
}
