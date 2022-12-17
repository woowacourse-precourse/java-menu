package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.utils.ViewMessage.*;

public class InputView {
    public static String readCoachName() {
        System.out.println(REQUEST_COACH_NAME);
        return Console.readLine();
    }
}
