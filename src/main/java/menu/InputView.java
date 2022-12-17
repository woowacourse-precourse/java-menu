package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class InputView {

    public List<String> getCouchNames() {
        System.out.println(MessageFormat.COUCH_NAME_REQUEST_COMMENT.getMessage());
        return List.of(getString().split(MessageFormat.INPUT_PARSER.getMessage()));
    }

    public List<String> getCannotEatMenuNames(String couchName) {
        try {
            System.out.println(String.format(MessageFormat.CANNOT_EAT_MENU_COMMENT_FORMAT.getMessage(), couchName));
            return List.of(getString().split(MessageFormat.INPUT_PARSER.getMessage()));
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }
    }

    public String getString() {
        return Console.readLine();
    }
}
