package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.Validation;

public class InputView {

    private String readLine() {
        return Console.readLine();
    }

    public String[] getCoachNames() {
        String input = readLine();
        Validation.isCoachNames(input);
        return input.split("\\s*,\\s*");
    }

    public String[] getCantEatMenus() {
        String input = readLine();
        Validation.isCantEatMenus(input);
        return input.split("\\s*,\\s*");
    }
}
