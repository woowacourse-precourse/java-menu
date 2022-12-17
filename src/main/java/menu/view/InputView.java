package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.Message;
import menu.utils.Validator;

public class InputView {
    public static String[] readCoachName() {
        System.out.println(Message.COACH_NAME);
        String input = Console.readLine().strip();
        Validator.isCorrectName(input);
        return input.split("\\s*,\\s*");
    }

    public String[] readDislikeMenu() {
        String input = Console.readLine().strip();
        return input.split("\\s*,\\s*");
    }
}
