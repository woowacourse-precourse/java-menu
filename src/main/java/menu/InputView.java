package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public List<String> getCouchNames() {
        System.out.println(MessageFormat.COUCH_NAME_REQUEST_COMMENT.getMessage());
        return List.of(getString().split(MessageFormat.INPUT_PARSER.getMessage()));
    }

    public List<String> getCannotEatMenuNames() {
        System.out.println(MessageFormat.CANNOT_EAT_MENU_COMMENT_FORMAT.getMessage());
        return List.of(getString().split(MessageFormat.INPUT_PARSER.getMessage()));
    }

    public String getString() {
        return Console.readLine();
    }
}
