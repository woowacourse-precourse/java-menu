package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coach;
import menu.utils.Message;
import menu.utils.Validator;

public class InputView {
    public static String[] readCoachName() {
        System.out.println(Message.COACH_NAME);
        String input = Console.readLine().strip();
        Validator.isCorrectName(input);
        return input.split("\\s*,\\s*");
    }

    public static String[] readDislikeMenu(String name) {
        System.out.println(name + Message.DISLIKE_MENU);
        String input = Console.readLine().strip();
        Validator.isCorrectMenuCount(input);
        return input.split("\\s*,\\s*");
    }
}
