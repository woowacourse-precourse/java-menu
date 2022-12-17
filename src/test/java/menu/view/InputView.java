package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String SPLIT_REGEX = "\\s*,\\s*";

    public static String[] readCoachNames(){
        String input = Console.readLine();
        String[] coachNames = parse(input);
        return coachNames;
    }
    private static String[] parse(String input){
        return input.split(SPLIT_REGEX);
    }
}
