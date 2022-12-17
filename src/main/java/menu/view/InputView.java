package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SEPARATOR = ",";

    public String[] readCoachNames() {
        return Console.readLine().split(SEPARATOR);
    }

}
