package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.view.OutputView.*;

public class InputView {

    public static String getCoachName() {
        printGetCoachNameMessage();
        String names = Console.readLine();
        return names;
    }

}
