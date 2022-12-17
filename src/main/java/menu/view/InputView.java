package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] readCoachName() {
        String input = Console.readLine().strip();

        return input.split("\\s*,\\s*");
    }

    public String[] readDislikeMenu() {
        String input = Console.readLine().strip();
        return input.split("\\s*,\\s*");
    }
}
